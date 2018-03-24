package pe.com.transaltisa.reportedefallas.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.model.MFallasDBDef;
import pe.com.transaltisa.reportedefallas.utils.SessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionManager session;
    private ListView mListView;
    private FallasDBHelper mDbHelper;
    private List<MFalla> listFallas;
    private ArrayList<String> mlistTitlesFallas;
    private MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LISTVIEW3", "LLEGO LIST VIEW3");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("LISTVIEW2", "LLEGO LIST VIEW2");
        mDbHelper = new FallasDBHelper(this);
        session = new SessionManager(getApplicationContext());
        mListView = (ListView) findViewById(R.id.lvReporteFallas);
        session.checkLogin();

        preaparListView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

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
            textView.setText("Reportes de Fallas");
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            // Definimos un array con los valores de los titulos de las notas
            // que presentaremos en el ListView
            mListView.addHeaderView(textView);
        }
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

        listFallas = mDbHelper.getAllFallos();

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


        public MyCustomAdapter(ArrayList<String> list, Context context) {
            this.list = list;
            this.context = context;
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

            ImageButton editBtn = (ImageButton) view.findViewById(R.id.edit_btn);
            //Handle buttons and add onClickListeners
            ImageButton deleteBtn = (ImageButton) view.findViewById(R.id.delete_btn);
            //ImageButton imgButtonCloud = (ImageButton) view.findViewById(R.id.add_btn);
            Button addBtn = (Button) view.findViewById(R.id.add_btn);

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MFalla selFalla = listFallas.get(position);

                    Log.i("MyActivity", "Selected Note: " + selFalla.getId_falla());
                  /*  Intent explicit_intent = new Intent(MainActivity.this, GuardarEditarActaActivity.class);
                    explicit_intent.putExtra("Acta", selActa);
                    MainActivity.this.startActivity(explicit_intent);*/

                }
            });

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //do something
                    // list.remove(position); //or some other task
                    //notifyDataSetChanged();
          /*          delActa = mAllActas.get(position);
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                    dialogo1.setTitle("Importante");
                    dialogo1.setMessage("¿Se eliminará el registro, desea realizar esta acción?");
                    dialogo1.setCancelable(false);
                    dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo1, int id) {
                            //flagEliminar = true;
                            if (mDbHelper != null) {

                                //Borramos la nota de la base de datos
                                mDbHelper.deleteNote(delActa);
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
                    dialogo1.show();*/
                }
            });
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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

}