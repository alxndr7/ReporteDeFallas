package pe.com.transaltisa.reportedefallas.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.utils.AlertDialogManager;

public class EditarReporte extends AppCompatActivity {

    private MFalla objRepFalla;
    private FallasDBHelper mDbHelper;
    AlertDialogManager alert = new AlertDialogManager();
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    EditText date,txtTime;
    Button btnEditar;
    Integer id_rep;
    final Calendar c = Calendar.getInstance();
    EditText _reporte_titulo, _fecha, _hora, _empresa, _convoy, _placa_tracto, _placa_carreta, _kilometraje, _ubicacion, _desc_falla;
    String titulo,fecha, hora, empresa, convoy, placa_tracto, placa_carreta, kilometraje, ubicacion, desc_falla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_reporte);
        mDbHelper = new FallasDBHelper(this);
      /*  Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            objRepFalla = (MFalla) extras.getSerializable("Acta");
            Log.i("MyActivity", "ON CREATE: " + objRepFalla.getId_falla());
        }*/

        date = (EditText) findViewById(R.id.edtxtFecha);
        txtTime = (EditText)findViewById(R.id.edtxtHora);
        btnEditar = (Button)findViewById(R.id.btnEditarReporte);
        _reporte_titulo = (EditText)findViewById(R.id.reporte_titulo);
        _fecha = (EditText)findViewById(R.id.edtxtFecha);
        _hora = (EditText)findViewById(R.id.edtxtHora);
        _empresa = (EditText)findViewById(R.id.edtxtEmpresa);
        _convoy = (EditText)findViewById(R.id.edtxtConvoy);
        _placa_tracto = (EditText)findViewById(R.id.edtxtPlacaTracto);
        _placa_carreta = (EditText)findViewById(R.id.edtxtPlacaCarreta);
        _kilometraje = (EditText)findViewById(R.id.edtxtKilometraje);
        _ubicacion = (EditText)findViewById(R.id.edtxtUbicacion);
        _desc_falla = (EditText)findViewById(R.id.edtxtDescFalla);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                // date picker dialog
                datePickerDialog = new DatePickerDialog(EditarReporte.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                int mhour  = c.get(Calendar.HOUR);
                int mMin = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(EditarReporte.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }
                        , mhour, mMin, false);
                timePickerDialog.show();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar_reporte();
            }
        });

        llenarCampos();

    }

    public void llenarCampos(){
        Intent intent= getIntent();
        MFalla objRepFalla = null;
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            objRepFalla = (MFalla) extras.getSerializable("Acta");
            id_rep = objRepFalla.getId_falla();
            _reporte_titulo.setText(objRepFalla.getTitulo());
            _fecha.setText(objRepFalla.getFecha_falla());
            _hora.setText(objRepFalla.getHora_falla());
            _empresa.setText(objRepFalla.getEmpresa());
            _convoy.setText(objRepFalla.getConvoy());
            _placa_tracto.setText(objRepFalla.getPlaca_tracto());
            _placa_carreta.setText(objRepFalla.getPlaca_carreta());
            _kilometraje.setText(objRepFalla.getKilometraje());
            _ubicacion.setText(objRepFalla.getUbicacion());
            _desc_falla.setText(objRepFalla.getDescripcion_falla());
        }
    }

    public void editar_reporte() {
        if (!validate()) {
            onSubmitFailed();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(EditarReporte.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Editando Reporte...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        update_reporte();
                        progressDialog.dismiss();
                        finish();
                    }
                }, 1000);
    }

    public void onSubmitFailed() {
        Toast.makeText(getBaseContext(), "Error al guardar reporte, revise si ingresó correctamente todos los campos.", Toast.LENGTH_LONG).show();
        btnEditar.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        titulo = _reporte_titulo.getText().toString();
        fecha = _fecha.getText().toString();
        hora = _hora.getText().toString();
        empresa = _empresa.getText().toString();
        convoy = _convoy.getText().toString();
        placa_tracto = _placa_tracto.getText().toString();
        placa_carreta = _placa_carreta.getText().toString();
        kilometraje = _kilometraje.getText().toString();
        ubicacion = _ubicacion.getText().toString();
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

        if (empresa.isEmpty()) {
            _empresa.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _empresa.setError(null);
        }

        if (convoy.isEmpty()) {
            _convoy.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _convoy.setError(null);
        }

        if (placa_tracto.isEmpty()) {
            _placa_tracto.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _placa_tracto.setError(null);
        }

        if (placa_carreta.isEmpty()) {
            _placa_carreta.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _placa_carreta.setError(null);
        }

        if (kilometraje.isEmpty()) {
            _kilometraje.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _kilometraje.setError(null);
        }

        if (ubicacion.isEmpty()) {
            _ubicacion.setError("Este campo es obligatorio");
            valid = false;
        } else {
            _ubicacion.setError(null);
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

    public void update_reporte(){

        titulo = _reporte_titulo.getText().toString();
        fecha = _fecha.getText().toString();
        hora = _hora.getText().toString();
        empresa = _empresa.getText().toString();
        convoy = _convoy.getText().toString();
        placa_tracto = _placa_tracto.getText().toString();
        placa_carreta = _placa_carreta.getText().toString();
        kilometraje = _kilometraje.getText().toString();
        ubicacion = _ubicacion.getText().toString();
        desc_falla = _desc_falla.getText().toString();

        MFalla repFalla = new MFalla();
        repFalla.setId_falla(id_rep);
        repFalla.setTitulo(titulo);
        repFalla.setFecha_falla(fecha);
        repFalla.setHora_falla(hora);
        repFalla.setEmpresa(empresa);
        repFalla.setConvoy(convoy);
        repFalla.setPlaca_tracto(placa_tracto);
        repFalla.setPlaca_carreta(placa_carreta);
        repFalla.setKilometraje(kilometraje);
        repFalla.setUbicacion(ubicacion);
        repFalla.setDescripcion_falla(desc_falla);

        if (mDbHelper != null){
            //Insertamos el nuevo registro
            mDbHelper.updateReporteFalla(repFalla);
            //Refrescamos el ListView
        }
    }

}
