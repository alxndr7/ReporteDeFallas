package pe.com.transaltisa.reportedefallas.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.model.Data;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.model.Usuario;
import pe.com.transaltisa.reportedefallas.utils.AlertDialogManager;
import pe.com.transaltisa.reportedefallas.utils.InstantAutoComplete;
import pe.com.transaltisa.reportedefallas.utils.SessionManager;

public class NuevoReporte extends AppCompatActivity {

    private FallasDBHelper mDbHelper;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    EditText date,txtTime;
    Button btnGuardar;
    String id_usuario = "0";
    final Calendar c = Calendar.getInstance();
    EditText _reporte_titulo, _fecha, _hora, _empresa, _convoy, _kilometraje, _desc_falla;
    String titulo,fecha, hora, ruta, empresa, flota, convoy, placa_tracto, placa_carreta, kilometraje, ubicacion, desc_falla;
    InstantAutoComplete _autoUbicacion, _autoTractos, _autoCarretas, _autoFlotas, _autoRutas;
   /* @BindView(R.id.edtxtFecha)
    EditText _fecha;
    @BindView(R.id.edtxtHora)
    EditText _hora;
    @BindView(R.id.edtxtEmpresa)
    EditText _empresa;
    @BindView(R.id.edtxtConvoy)
    EditText _convoy;
    @BindView(R.id.edtxtPlacaTracto)
    EditText _placa_tracto;
    @BindView(R.id.edtxtPlacaCarreta)
    EditText _placa_carreta;
    @BindView(R.id.edtxtKilometraje)
    EditText _kilometraje;
    @BindView(R.id.edtxtUbicacion)
    EditText _ubicacion;
    @BindView(R.id.edtxtDescFalla)
    EditText _desc_falla;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_reporte);
        mDbHelper = new FallasDBHelper(this);
        Data datos = new Data();

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        id_usuario = user.get(SessionManager.ID_INSPECTOR);

        date = (EditText) findViewById(R.id.edtxtFecha);
        txtTime = (EditText)findViewById(R.id.edtxtHora);
        btnGuardar = (Button)findViewById(R.id.btnGuardarReporte);
        _reporte_titulo = (EditText)findViewById(R.id.reporte_titulo);
        _fecha = (EditText)findViewById(R.id.edtxtFecha);
        _hora = (EditText)findViewById(R.id.edtxtHora);
        _empresa = (EditText)findViewById(R.id.edtxtEmpresa);
        _convoy = (EditText)findViewById(R.id.edtxtConvoy);
        //_placa_tracto = (EditText)findViewById(R.id.edtxtPlacaTracto);
        //_placa_carreta = (EditText)findViewById(R.id.edtxtPlacaCarreta);
        _kilometraje = (EditText)findViewById(R.id.edtxtKilometraje);
        //_ubicacion = (EditText)findViewById(R.id.edtxtUbicacion);
        _desc_falla = (EditText)findViewById(R.id.edtxtDescFalla);
        _autoUbicacion = (InstantAutoComplete) findViewById(R.id.autoUbicacion);
        _autoCarretas = (InstantAutoComplete) findViewById(R.id.autoCarretas);
        _autoTractos = (InstantAutoComplete) findViewById(R.id.autoTractos);
        _autoFlotas = (InstantAutoComplete) findViewById(R.id.autoFlotas);
        _autoRutas = (InstantAutoComplete) findViewById(R.id.autoRutas);

        String[] tramos = datos.getTramos();
        String[] tractos = datos.getPlacasTracto();
        String[] carretas = datos.getPlacasCarreta();
        String[] flotas = datos.getFlotas();
        String[] rutas = datos.getRutas();

        ArrayAdapter<String> adapterTramos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tramos);
        ArrayAdapter<String> adapterTractos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tractos);
        ArrayAdapter<String> adapterCarretas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, carretas);
        ArrayAdapter<String> adapterFlotas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, flotas);
        ArrayAdapter<String> adapterRutas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rutas);

        _autoUbicacion.setAdapter(adapterTramos);
        _autoCarretas.setAdapter(adapterCarretas);
        _autoTractos.setAdapter(adapterTractos);
        _autoFlotas.setAdapter(adapterFlotas);
        _autoRutas.setAdapter(adapterRutas);

        /*_autoFlotas.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if(!_autoFlotas.isPopupShowing()){
                    _autoFlotas.showDropDown();
                }
//                _autoFlotas.showDropDown();
                return false;
            }
        });

        _autoUbicacion.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if(!_autoUbicacion.isPopupShowing()){
                    _autoUbicacion.showDropDown();
                }
//                _autoFlotas.showDropDown();
                return false;
            }
        });

        _autoCarretas.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if(!_autoCarretas.isPopupShowing()){
                    _autoCarretas.showDropDown();
                }
//                _autoFlotas.showDropDown();
                return false;
            }
        });

        _autoTractos.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){

                if(!_autoTractos.isPopupShowing()){
                    _autoTractos.showDropDown();
                }
//                _autoFlotas.showDropDown();
                return false;
            }
        });*/

        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        int mhour  = c.get(Calendar.HOUR_OF_DAY);
        int mMin = c.get(Calendar.MINUTE);

        date.setText(mYear + "-" + (mMonth + 1) + "-" + mDay );
        date.setEnabled(false);
        txtTime.setText(mhour + ":" + mMin);
        txtTime.setEnabled(false);



/*        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                date.setText(mYear + "-" + (mMonth + 1) + "-" + mDay );
                // date picker dialog
                datePickerDialog = new DatePickerDialog(NuevoReporte.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });*/

      /*  txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                int mhour  = c.get(Calendar.HOUR);
                int mMin = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(NuevoReporte.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }
                        , mhour, mMin, false);
                timePickerDialog.show();
                // date picker dialog
               *//* timePickerDialog = new TimePickerDialog(NuevoReporte.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();*//*
            }
        });*/

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar_reporte();
            }
        });

    }

    public void guardar_reporte() {
        if (!validate()) {
            onSubmitFailed();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(NuevoReporte.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Guardando Reporte...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                            insert_reporte();
                            progressDialog.dismiss();
                            finish();
                    }
                }, 1000);
    }

    public void onSubmitFailed() {
        Toast.makeText(getBaseContext(), "Error al guardar reporte, revise si ingresó correctamente todos los campos.", Toast.LENGTH_LONG).show();
        btnGuardar.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        titulo = _reporte_titulo.getText().toString();
        fecha = _fecha.getText().toString();
        hora = _hora.getText().toString();
        ruta = _autoRutas.getText().toString();
        empresa = _empresa.getText().toString();
        flota = _autoFlotas.getText().toString();
        convoy = _convoy.getText().toString();
        placa_tracto = _autoTractos.getText().toString();
        placa_carreta = _autoCarretas.getText().toString();
        kilometraje = _kilometraje.getText().toString();
        ubicacion = _autoUbicacion.getText().toString();
        desc_falla = _desc_falla.getText().toString();

        if (titulo.isEmpty()) {
            _reporte_titulo.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _reporte_titulo.setError(null);
        }

        if (fecha.isEmpty()) {
            _fecha.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _fecha.setError(null);
        }

        if (hora.isEmpty()) {
            _hora.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _hora.setError(null);
        }

        if (ruta.isEmpty()) {
            _autoRutas.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _autoRutas.setError(null);
        }


        if (empresa.isEmpty()) {
            _empresa.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _empresa.setError(null);
        }

        if (flota.isEmpty()) {
            _autoFlotas.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _autoFlotas.setError(null);
        }


        if (convoy.isEmpty()) {
            _convoy.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _convoy.setError(null);
        }

        if (placa_tracto.isEmpty()) {
            _autoTractos.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _autoTractos.setError(null);
        }

        if (placa_carreta.isEmpty()) {
            _autoCarretas.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _autoCarretas.setError(null);
        }

        if (kilometraje.isEmpty()) {
            _kilometraje.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _kilometraje.setError(null);
        }

        if (ubicacion.isEmpty()) {
            _autoUbicacion.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _autoUbicacion.setError(null);
        }

        if (desc_falla.isEmpty()) {
            _desc_falla.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _desc_falla.setError(null);
        }
       /* if (fecha.isEmpty()) {
            _fecha.setError("Entre 4 y 10 caracteres alfanuméricos");
            valid = false;
        } else {
            _fecha.setError(null);
        }*/

        return valid;
    }

    public void insert_reporte(){

        titulo = _reporte_titulo.getText().toString();
        fecha = _fecha.getText().toString();
        hora = _hora.getText().toString();
        ruta = _autoRutas.getText().toString();
        empresa = _empresa.getText().toString();
        flota = _autoFlotas.getText().toString();
        convoy = _convoy.getText().toString();
        placa_tracto = _autoTractos.getText().toString();
        placa_carreta = _autoCarretas.getText().toString();
        kilometraje = _kilometraje.getText().toString();
        ubicacion = _autoUbicacion.getText().toString();
        desc_falla = _desc_falla.getText().toString();

        MFalla repFalla = new MFalla();
        repFalla.setTitulo(titulo);
        repFalla.setFecha_falla(fecha);
        repFalla.setHora_falla(hora);
        repFalla.setRuta(ruta);
        repFalla.setEmpresa(empresa);
        repFalla.setFlota(flota);
        repFalla.setConvoy(convoy);
        repFalla.setPlaca_tracto(placa_tracto);
        repFalla.setPlaca_carreta(placa_carreta);
        repFalla.setKilometraje(kilometraje);
        repFalla.setUbicacion(ubicacion);
        repFalla.setDescripcion_falla(desc_falla);
        repFalla.setEstado("1");
        repFalla.setEstado_envio("0");
        repFalla.setId_usuario(id_usuario);

        Log.d("REPORTE", repFalla.toString());

        if (mDbHelper != null){
            //Insertamos el nuevo registro
            mDbHelper.insertReporte(repFalla);
            //Refrescamos el ListView
        }
    }

}
