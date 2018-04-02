package pe.com.transaltisa.reportedefallas.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.api.ApiService;
import pe.com.transaltisa.reportedefallas.api.RetroClient;
import pe.com.transaltisa.reportedefallas.api.response.Prueba;
import pe.com.transaltisa.reportedefallas.api.response.Result;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.model.MFallasDBDef;
import pe.com.transaltisa.reportedefallas.utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionManager session;
    private ListView mListView;
    private FallasDBHelper mDbHelper;
    private List<MFalla> listFallas;
    private ArrayList<String> mlistTitlesFallas;
    private MyCustomAdapter adapter;
    private MFalla delRepFalla, uploadRepFalla;
    private String id_usuario = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        session = new SessionManager(getApplicationContext());
        mListView = (ListView) findViewById(R.id.lvReporteFallas);
        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);

        id_usuario = user.get(SessionManager.ID_INSPECTOR);
        Log.i("LOGIN", name + email + " " + id_usuario );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NuevoReporte.class);
                MainActivity.this.startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mDbHelper = new FallasDBHelper(this);
        preaparListView();
    }

    @Override
    protected void onRestart() {
// TODO Auto-generated method stub
        super.onRestart();
        resfreshNotes();
        //Do your code here
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cloud_sync) {
            sincronizar_todo();
            // Handle the camera action
        } else if (id == R.id.logout) {
            session.logoutUser();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void preaparListView() {
        //Instanciamos el ListView

        if (mListView.getHeaderViewsCount() == 0) {
            TextView textView = new TextView(this);
            textView.setTextSize(24);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText("Listado de Reportes");
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            // Definimos un array con los valores de los titulos de las notas
            // que presentaremos en el ListView
            mListView.addHeaderView(textView);
        }
        if(id_usuario == null)
            id_usuario= "0";

        resfreshNotes();
        //instantiate custom adapter
        adapter = new MyCustomAdapter(mlistTitlesFallas, this);

        // Asiganmos el adapter al ListView, para presentar los datos en pantalla
        if (mListView != null) {
            mListView.setAdapter(adapter);

        }
    }

    private void resfreshNotes() {
        //Cargamos todas las notas

        listFallas = mDbHelper.getAllFallos(id_usuario);

        //Iteramos sobre todas las notas para pasar los titulos a un Array String

        int idx = 0;
        mlistTitlesFallas = new ArrayList<String>();
        for (MFalla falla : listFallas) {
            mlistTitlesFallas.add(idx + 1 + ".-" + falla.getTitulo());
            idx++;
        }

        //Si el Adapter esta instanciado notificamos los cambios
        if (adapter != null) {
            //Limpiamos todos los datos
            adapter.clear();
            //Agreamos los nuevos datos
            //instantiate custom adapter
            adapter = new MyCustomAdapter(mlistTitlesFallas, this);

            if (mListView != null) {
                mListView.setAdapter(adapter);

            }
            //Notificamos los cambios
            adapter.notifyDataSetChanged();
        }
    }

    public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
        private ArrayList<String> list = new ArrayList<String>();
        private Context context;
        private  AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
        final Animation myAnim;
        public MyCustomAdapter(ArrayList<String> list, Context context) {
            this.list = list;
            this.context = context;
            myAnim = AnimationUtils.loadAnimation(this.context, R.anim.bounce_buttons);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int pos) {
            return list.get(pos);
        }

        @Override
        public long getItemId(int pos) {

            //return list.get(pos).getId();
            //just return 0 if your list items do not have an Id variable.
            return 0;
        }

        public void clear() {
            // TODO Auto-generated method stub

            list.clear();
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_layout_lv, null);
            }

            //Handle TextView and display string from your list
            TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
            listItemText.setText(list.get(position));

            final Button editBtn = (Button) view.findViewById(R.id.edit_btn);
            final Button deleteBtn = (Button) view.findViewById(R.id.delete_btn);
            final Button addBtn = (Button) view.findViewById(R.id.add_btn);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    editBtn.startAnimation(myAnim);
                    MFalla selFalla = listFallas.get(position);

                    Log.i("MyActivity", "Selected Note: " + selFalla.getId_falla());
                    Intent explicit_intent = new Intent(MainActivity.this, EditarReporte.class);
                    explicit_intent.putExtra("Acta", selFalla);
                    MainActivity.this.startActivity(explicit_intent);
//                    MainActivity.this.startActivity(explicit_intent);

                }
            });

     /*       deleteBtn.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                            v.invalidate();
                            break;
                        }
                        case MotionEvent.ACTION_UP: {
                            v.getBackground().clearColorFilter();
                            v.invalidate();
                            break;
                        }
                    }
                    return false;
                }
            });*/

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   /* v.startAnimation(buttonClick);*/

                    deleteBtn.startAnimation(myAnim);

                    //do something
                    // list.remove(position); //or some other task
                    //notifyDataSetChanged();
                    delRepFalla = listFallas.get(position);
                    Log.d("ITEM DELETE","Item id:" + delRepFalla.getId_falla());
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                    dialogo1.setTitle("Importante");
                    dialogo1.setIcon(R.drawable.alert);
                    dialogo1.setMessage("¿Se eliminará el registro de forma permanente, desea realizar esta acción?");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            //flagEliminar = true;
                            if (mDbHelper != null) {
                                //Borramos la nota de la base de datos
                                mDbHelper.updateEstadoReporte(delRepFalla);
                                //Refrescamos la lista de notas
                                resfreshNotes();
                                //Devolvemos true para evitar que se ejecute el OnItemClickListener
                            }
                        }
                    });
                    dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            //flagEliminar= false;
                            dialogo1.dismiss();
                        }
                    });
                    dialogo1.show();
                }
            });
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    addBtn.startAnimation(myAnim);

                    uploadRepFalla = listFallas.get(position);

                    subir_reporte(uploadRepFalla);
                   /* if (InternetConnection.checkConnection(mContext)) {
                        *//******************Retrofit***************//*
                        uploadActa = mAllActas.get(position);
                        Log.i("ONCLICK", "Reg dat: " +  uploadActa.getId_reg_dat());
                        uploadImage(uploadActa);
                    }*/
                }
            });

            return view;
        }
    }

    private void sincronizar_todo() {

        final ProgressDialog progressDialog;
        List<MFalla> listaSync = mDbHelper.getAllFallos(id_usuario);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Subiendo información...");
        progressDialog.show();

        ApiService service = RetroClient.getApiService();

        for(int i =0; i<listaSync.size();i++) {
            final MFalla fobj = listaSync.get(i);
            Call<Result> resultCall = service.pruebajson(fobj.getTitulo(), fobj.getEmpresa(), fobj.getFecha_falla() + " " + fobj.getHora_falla() + ":00", fobj.getConvoy(), fobj.getPlaca_tracto(),
                    fobj.getPlaca_carreta(), fobj.getKilometraje(), fobj.getUbicacion(), fobj.getDescripcion_falla(),Integer.parseInt(fobj.getId_usuario()));

            resultCall.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    progressDialog.dismiss();
                    Log.i("FOR RESPONSE", new Gson().toJson(response));
                    if (response.isSuccessful()) {
                        Log.d("RESPONSE JSON", "BODY:" + response.body());

                        Toast.makeText(getBaseContext(), "Se Subió correctamente el reporte...", Toast.LENGTH_LONG).show();
                        if (mDbHelper != null) {
                            //Borramos la nota de la base de datos
                            mDbHelper.updateEstadoReporte(fobj);
                            //Refrescamos la lista de notas
                            resfreshNotes();
                            //Devolvemos true para evitar que se ejecute el OnItemClickListener
                        }
                    } else {
                        Log.i("RESPONSE", "RESPONSE NOT SUCCESSFUL");
                        Toast.makeText(getBaseContext(), "Hubo un error al conectarse con el servidor...", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    progressDialog.dismiss();
                    Log.i("RESPONSE", t.getMessage());
                    Toast.makeText(getBaseContext(), "Tiempo de espera agotado, asegúrese de estar conectado a una red apropiada.", Toast.LENGTH_LONG).show();
                }
            });

        }
    }


    private void subir_reporte(MFalla obj) {

        final ProgressDialog progressDialog;
        final MFalla fobj = obj;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Subiendo información...");
        progressDialog.show();

        listFallas = mDbHelper.getAllFallos(id_usuario);
        ApiService service = RetroClient.getApiService();
        Call<Result> resultCall = service.pruebajson(obj.getTitulo(),obj.getEmpresa(),obj.getFecha_falla() + " " + obj.getHora_falla()+ ":00", obj.getConvoy(),obj.getPlaca_tracto(),
                obj.getPlaca_carreta(),obj.getKilometraje(),obj.getUbicacion(),obj.getDescripcion_falla(), Integer.parseInt(fobj.getId_usuario()));

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                progressDialog.dismiss();
                Log.i("FOR RESPONSE", new Gson().toJson(response));
                if (response.isSuccessful()) {
                    Log.d("RESPONSE JSON", "BODY:" + response.body());

                    Toast.makeText(getBaseContext(), "Se Subió correctamente el reporte...", Toast.LENGTH_LONG).show();
                    if (mDbHelper != null) {
                        //Borramos la nota de la base de datos
                        mDbHelper.updateEstadoReporte(fobj);
                        //Refrescamos la lista de notas
                        resfreshNotes();
                        //Devolvemos true para evitar que se ejecute el OnItemClickListener
                    }
                }
                else {
                    Log.i("RESPONSE", "RESPONSE NOT SUCCESSFUL");
                    Toast.makeText(getBaseContext(), "Hubo un error al conectarse con el servidor...", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Log.i("RESPONSE", t.getMessage());
                Toast.makeText(getBaseContext(), "Tiempo de espera agotado, asegúrese de estar conectado a una red apropiada.", Toast.LENGTH_LONG).show();
            }
        });


    }

}
