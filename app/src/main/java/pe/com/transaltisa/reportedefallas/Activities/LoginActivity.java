package pe.com.transaltisa.reportedefallas.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import pe.com.transaltisa.reportedefallas.R;
import pe.com.transaltisa.reportedefallas.model.FallasDBHelper;
import pe.com.transaltisa.reportedefallas.model.MFalla;
import pe.com.transaltisa.reportedefallas.model.Usuario;
import pe.com.transaltisa.reportedefallas.utils.AlertDialogManager;
import pe.com.transaltisa.reportedefallas.utils.SessionManager;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private FallasDBHelper mDbHelper;
    SessionManager session;
    AlertDialogManager alert = new AlertDialogManager();

    @BindView(R.id.edtxtUsuario)
    EditText _usuario;
    @BindView(R.id.edtxtPassword)
    EditText _password;
    @BindView(R.id.btn_login)
    Button _loginButton;
    //@Bind(R.id.link_signup) TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // Session Manager
        session = new SessionManager(getApplicationContext());
        mDbHelper = new FallasDBHelper(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }
        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Autenticando...");
        progressDialog.show();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        String username = _usuario.getText().toString();
                        String password = _password.getText().toString();
                        Usuario usu = null;
                        usu = mDbHelper.validarLogin(username,password);
                            if(usu != null){

                                // Creating user login session
                                // For testing i am stroing name, email as follow
                                // Use user real data
                                onLoginSuccess(usu.getId_usuario() + "" , usu.getNombre_usuario());
                                progressDialog.dismiss();
                                //session.createLoginSession("Android Hive", "anroidhive@gmail.com");

                                //login();

                            }else{
                                // username / password doesn't match
                                alert.showAlertDialog(LoginActivity.this, "Error al intentar ingresar...", "Usuario o contraseña incorrectos", false);
                                _loginButton.setEnabled(true);
                                progressDialog.dismiss();
                            }

                    }
                }, 1000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(String id_inspector, String nombre) {

        session.createLoginSession(nombre, "anroidhive@gmail.com",id_inspector);
        _loginButton.setEnabled(true);
        // Staring MainActivity
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _usuario.getText().toString();
        String password = _password.getText().toString();

        if (email.isEmpty()) {
            _usuario.setError("Ingrese un usuario válido");
            valid = false;
        } else {
            _usuario.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _password.setError("Entre 4 y 10 caracteres alfanuméricos");
            valid = false;
        } else {
            _password.setError(null);
        }

        return valid;
    }
}
