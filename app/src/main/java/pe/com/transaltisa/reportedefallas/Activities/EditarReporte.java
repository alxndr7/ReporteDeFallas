package pe.com.transaltisa.reportedefallas.Activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.model.Data;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.utils.AlertDialogManager;
import pe.com.transaltisa.reportedefallas.utils.DbBitmapUtility;
import pe.com.transaltisa.reportedefallas.utils.InstantAutoComplete;

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
    EditText _reporte_titulo, _fecha, _hora, _empresa, _convoy, _kilometraje, _desc_falla;
    String titulo,fecha, hora,ruta, empresa, flota, convoy, placa_tracto, placa_carreta, kilometraje, ubicacion, desc_falla;
    InstantAutoComplete _autoUbicacion, _autoTractos, _autoCarretas, _autoFlotas, _autoRutas;
    ImageView imageView1, imageView2, imageView3;
    DbBitmapUtility imageUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_reporte);
        mDbHelper = new FallasDBHelper(this);
        Data datos = new Data();

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
        _kilometraje = (EditText)findViewById(R.id.edtxtKilometraje);
        _desc_falla = (EditText)findViewById(R.id.edtxtDescFalla);
        _autoUbicacion = (InstantAutoComplete) findViewById(R.id.autoUbicacion);
        _autoCarretas = (InstantAutoComplete) findViewById(R.id.autoCarretas);
        _autoTractos = (InstantAutoComplete) findViewById(R.id.autoTractos);
        _autoFlotas = (InstantAutoComplete) findViewById(R.id.autoFlotas);
        _autoRutas = (InstantAutoComplete) findViewById(R.id.autoRutas);

        imageView1 = (ImageView) findViewById(R.id.image_1);
        imageView2 = (ImageView) findViewById(R.id.image_2);
        imageView3 = (ImageView) findViewById(R.id.image_3);

        date.setEnabled(false);
        txtTime.setEnabled(false);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar_reporte();
            }
        });

        llenarCampos();

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
            _autoRutas.setText(objRepFalla.getRuta());
            _empresa.setText(objRepFalla.getEmpresa());
            _autoFlotas.setText(objRepFalla.getFlota());
            _convoy.setText(objRepFalla.getConvoy());
            _autoTractos.setText(objRepFalla.getPlaca_tracto());
            _autoCarretas.setText(objRepFalla.getPlaca_carreta());
            _kilometraje.setText(objRepFalla.getKilometraje());
            _autoUbicacion.setText(objRepFalla.getUbicacion());
            _desc_falla.setText(objRepFalla.getDescripcion_falla());

            if(objRepFalla.getImage() != null)
                imageView1.setImageBitmap(imageUtil.getImage(objRepFalla.getImage()));
            if(objRepFalla.getImage2() != null)
                imageView2.setImageBitmap(imageUtil.getImage(objRepFalla.getImage2()));
            if(objRepFalla.getImage3() != null)
                imageView3.setImageBitmap(imageUtil.getImage(objRepFalla.getImage3()));

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

    public void update_reporte(){

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
        repFalla.setId_falla(id_rep);
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

        if (mDbHelper != null){
            //Insertamos el nuevo registro
            mDbHelper.updateReporteFalla(repFalla);
            //Refrescamos el ListView
        }
    }

}
