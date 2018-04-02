package pe.com.transaltisa.reportedefallas.utils;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pe.com.transaltisa.reportedefallas.Activities.MainActivity;
import pe.com.transaltisa.reportedefallas.api.ApiService;
import pe.com.transaltisa.reportedefallas.api.RetroClient;
import pe.com.transaltisa.reportedefallas.api.response.Result;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyService extends Service {

    static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    NotificationManager manager ;
    public boolean run;
    public static Timer timer = new Timer();
    private FallasDBHelper mDbHelper;

   /*
    final TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Log.i("NETWORK123","Connected every 1500");
        }
    };*/



    public MyService() {
        mDbHelper = new FallasDBHelper(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (CONNECTIVITY_CHANGE_ACTION.equals(action)) {
                    //check internet connection
                    if (!ConnectionHelper.isConnectedOrConnecting(context)) {
                        if (context != null) {
                            boolean show = false;
                            if (ConnectionHelper.lastNoConnectionTs == -1) {//first time
                                show = true;
                                ConnectionHelper.lastNoConnectionTs = System.currentTimeMillis();
                            } else {
                                if (System.currentTimeMillis() - ConnectionHelper.lastNoConnectionTs > 1000) {
                                    show = true;
                                    ConnectionHelper.lastNoConnectionTs = System.currentTimeMillis();
                                }
                            }

                            if (show && ConnectionHelper.isOnline) {
                                run =false;
                                ConnectionHelper.isOnline = false;
                                Log.i("NETWORK123","Connection lost");
                                //manager.cancelAll();
                            }
                        }
                    } else {
                        Log.i("NETWORK123","Connected");
                        //showNotifications("APP" , "It is working");
                        // Perform your actions here
                        run = true;
                        ConnectionHelper.isOnline = true;
                        timer.cancel();
                        timer.purge();
                        timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                if(run) {
                                    int countRep = mDbHelper.getCountReportesPorEnviar();
                                    Log.i("NETWORK123", "Reportes: " + countRep);
                                    if (countRep > 0)
                                        sincronizar_todo();
                                }

                            }
                        }, 0, 10000);
                        //timer.scheduleAtFixedRate(task, 0, 1500);
                    }
                }
            }
        };
        registerReceiver(receiver,filter);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    private void sincronizar_todo() {

        final ProgressDialog progressDialog;
        List<MFalla> listaSync = mDbHelper.getAllReportesPorEnviar();

        ApiService service = RetroClient.getApiService();

        for(int i =0; i<listaSync.size();i++) {
            final MFalla fobj = listaSync.get(i);
            Call<Result> resultCall = service.pruebajson(fobj.getTitulo(), fobj.getEmpresa(), fobj.getFecha_falla() + " " + fobj.getHora_falla() + ":00", fobj.getConvoy(), fobj.getPlaca_tracto(),
                    fobj.getPlaca_carreta(), fobj.getKilometraje(), fobj.getUbicacion(), fobj.getDescripcion_falla(),Integer.parseInt(fobj.getId_usuario()));

            resultCall.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {

                    Log.i("FOR RESPONSE", new Gson().toJson(response));
                    if (response.isSuccessful()) {
                        Log.d("RESPONSE JSON", "BODY:" + response.body());

                        Toast.makeText(getBaseContext(), "Se Subió correctamente el reporte...", Toast.LENGTH_LONG).show();
                        if (mDbHelper != null) {
                            //Borramos la nota de la base de datos
                            mDbHelper.setEstadoEnviado(fobj);
                            //Refrescamos la lista de notas
                            //Devolvemos true para evitar que se ejecute el OnItemClickListener
                        }
                    } else {
                        Log.i("RESPONSE", "RESPONSE NOT SUCCESSFUL");
                        Toast.makeText(getBaseContext(), "Hubo un error al conectarse con el servidor...", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    Log.i("RESPONSE", t.getMessage());
                    Toast.makeText(getBaseContext(), "Tiempo de espera agotado, asegúrese de estar conectado a una red apropiada.", Toast.LENGTH_LONG).show();
                }
            });

        }
    }

}
