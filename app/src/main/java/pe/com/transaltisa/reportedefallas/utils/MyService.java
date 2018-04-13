package pe.com.transaltisa.reportedefallas.utils;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.sql.Blob;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.com.transaltisa.reportedefallas.Activities.MainActivity;
import pe.com.transaltisa.reportedefallas.api.ApiService;
import pe.com.transaltisa.reportedefallas.api.RetroClient;
import pe.com.transaltisa.reportedefallas.api.response.Result;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MyService extends Service {

    static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    NotificationManager manager ;
    public boolean run;
    public static Timer timer = new Timer();
    private FallasDBHelper mDbHelper;
    DbBitmapUtility imageUtil;

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
                                        Log.i("NETWORK123", "ANTES DE SINCRONIZAR: " + countRep);
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
            Log.d("SYNC",fobj.toString());
            //File partFile = fobj.getImage();
            //RequestBody bodyImage1 = RequestBody.create(MediaType.parse("image"), fobj.getImage());
            //TypedInput typedBytes = new TypedByteArray("application/octet-stream",  byteArray);

   /*         File file = new File(imagePath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part imageFileBody = MultipartBody.Part.createFormData("media", file.getName(), requestBody);
*/
            RequestBody titulo = RequestBody.create(MediaType.parse("text/plain"),fobj.getTitulo());
            RequestBody empresa = RequestBody.create(MediaType.parse("text/plain"),fobj.getEmpresa());
            RequestBody ruta = RequestBody.create(MediaType.parse("text/plain"),fobj.getRuta());
            RequestBody reporteFecha = RequestBody.create(MediaType.parse("text/plain"),fobj.getFecha_falla());
            RequestBody flota = RequestBody.create(MediaType.parse("text/plain"),fobj.getFlota());
            RequestBody convoy = RequestBody.create(MediaType.parse("text/plain"),fobj.getConvoy());
            RequestBody placaTracto = RequestBody.create(MediaType.parse("text/plain"),fobj.getPlaca_tracto());
            RequestBody placaCarreta = RequestBody.create(MediaType.parse("text/plain"),fobj.getPlaca_carreta());
            RequestBody kilometraje = RequestBody.create(MediaType.parse("text/plain"),fobj.getKilometraje());
            RequestBody ubicacion = RequestBody.create(MediaType.parse("text/plain"),fobj.getUbicacion());
            RequestBody descFalla = RequestBody.create(MediaType.parse("text/plain"),fobj.getDescripcion_falla());
            RequestBody idUsuario = RequestBody.create(MediaType.parse("text/plain"),fobj.getId_usuario());

            File f = new File(this.getCacheDir(), "image1");
            try {
                f.createNewFile();
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(fobj.getImage());
                fos.flush();
                fos.close();
            } catch(MalformedURLException e) {
                //Do something with the exception.
            } catch(IOException e2) {
                //Do something with the exception.
            }

            MediaType MEDIA_TYPE_PNG = MediaType.parse("image/jpeg");

            RequestBody requestBody1 = RequestBody.create(MEDIA_TYPE_PNG, fobj.getImage());
            Log.d(TAG, "requestBody: " + requestBody1.toString());
            RequestBody imageBody = new MultipartBody.Builder()
                    .addFormDataPart("photo", "t.jpg", requestBody1)
                    .build();
            Log.d(TAG, "requestBody: " + imageBody.toString());



        /*    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            Blob blob = fobj.getImage();
            InputStream in = blob.getBinaryStream();
            OutputStream out = new FileOutputStream(someFile);
            byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
            int len = 0;

            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
*/
            Log.i("FILE",f.getAbsolutePath() + " - " + f.getName());
            RequestBody image = RequestBody.create(MediaType.parse("multipart/form-data"), f);
            //MultipartBody.Part imageBody =  MultipartBody.Part.createFormData("Image", "Fileimage", image);
            //String imageText = new String(fobj.getImage(),"UTF-8");
            //RequestBody bodyImage1 = RequestBody.create(MediaType.parse("text/plain"),new String(fobj.getImage()));
//            MultipartBody.Part bodyImage1 =  MultipartBody.Part.createFormData("imagen1", "imagen1", requestImage1);
            Call<Result> resultCall = service.pruebajson(titulo,empresa,ruta,reporteFecha,flota,convoy,placaTracto,placaCarreta,kilometraje,ubicacion,descFalla,idUsuario,imageBody);
           /* Call<Result> resultCall = service.pruebajson(fobj.getTitulo(),fobj.getEmpresa(),fobj.getRuta(),fobj.getFecha_falla(),
                    fobj.getFlota(),fobj.getFlota(),fobj.getPlaca_tracto(),fobj.getPlaca_carreta(),fobj.getKilometraje(),
                    fobj.getUbicacion(),fobj.getDescripcion_falla(),fobj.getId_usuario());*/

            resultCall.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {

                    Log.i("FOR RESPONSE", new Gson().toJson(response));
                    Log.i("FOR RESPONSE", "" + response.body());
                    //Log.i("Response", response.body().toString());
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
                        switch (response.code()) {
                            case 404:
                                //Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
                                Log.i("RESPONSE", "not found: " + response.code());
                                break;
                            case 500:
                                //Toast.makeText(this, "server broken", Toast.LENGTH_SHORT).show();
                                Log.i("RESPONSE", "server broken: " +response.code());
                                break;
                            default:
                                Log.i("RESPONSE", "unknown error:" + response.code());
                                //Toast.makeText(ErrorHandlingActivity.this, "unknown error", Toast.LENGTH_SHORT).show();
                                break;
                        }

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
