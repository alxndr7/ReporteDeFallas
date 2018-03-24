package pe.com.transaltisa.reportedefallas.model;

import java.io.Serializable;

/**
 * Created by ExpoCode Tech http://expocodetech.com
 */
@SuppressWarnings("serial")
public class Usuario implements Serializable {
    private int id_usuario;
    private String nombre_usuario;
    private String login;
    private String password;

    public Usuario(){

    }

    public Usuario(String nombre_usuario, String login, String password) {
        this.nombre_usuario = nombre_usuario;
        this.login = login;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
