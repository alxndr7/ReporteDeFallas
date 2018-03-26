package pe.com.transaltisa.reportedefallas.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prueba {

    @SerializedName("id_inspecc")
    @Expose
    private int id_inspecc;

    @SerializedName("id_reg_dat")
    @Expose
    private int id_reg_dat;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("id_inspector")
    @Expose
    private String id_inspector;

    @SerializedName("expediente")
    @Expose
    private String expediente;

    @SerializedName("direccion")
    @Expose
    private String direccion;

    public int getIde_inspecc() {
        return id_inspecc;
    }

    public void setIde_inspecc(int ide_inspecc) {
        this.id_inspecc = ide_inspecc;
    }

    public int getId_reg_dat() {
        return id_reg_dat;
    }

    public void setId_reg_dat(int id_reg_dat) {
        this.id_reg_dat = id_reg_dat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_inspector() {
        return id_inspector;
    }

    public void setId_inspector(String id_inspector) {
        this.id_inspector = id_inspector;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}