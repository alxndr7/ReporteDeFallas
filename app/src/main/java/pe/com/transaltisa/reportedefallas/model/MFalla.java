package pe.com.transaltisa.reportedefallas.model;

import java.io.Serializable;

/**
 * Created by ExpoCode Tech http://expocodetech.com
 */
@SuppressWarnings("serial")
public class MFalla implements Serializable {
    private int id_falla;
    private String titulo;
    private String fecha_falla;
    private String hora_falla;
    private String empresa;
    private String convoy;
    private String placa_tracto;
    private String placa_carreta;
    private String kilometraje;
    private String ubicacion;
    private String descripcion_falla;

    public MFalla(){
    }

    public MFalla( String titulo, String fecha_falla, String hora_falla, String empresa, String convoy, String placa_tracto, String placa_carreta, String kilometraje, String ubicacion, String descripcion_falla) {
        this.titulo = titulo;
        this.fecha_falla = fecha_falla;
        this.hora_falla = hora_falla;
        this.empresa = empresa;
        this.convoy = convoy;
        this.placa_tracto = placa_tracto;
        this.placa_carreta = placa_carreta;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.descripcion_falla = descripcion_falla;
    }

    public int getId_falla() {
        return id_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_falla() {
        return fecha_falla;
    }

    public void setFecha_falla(String fecha_falla) {
        this.fecha_falla = fecha_falla;
    }

    public String getHora_falla() {
        return hora_falla;
    }

    public void setHora_falla(String hora_falla) {
        this.hora_falla = hora_falla;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConvoy() {
        return convoy;
    }

    public void setConvoy(String convoy) {
        this.convoy = convoy;
    }

    public String getPlaca_tracto() {
        return placa_tracto;
    }

    public void setPlaca_tracto(String placa_tracto) {
        this.placa_tracto = placa_tracto;
    }

    public String getPlaca_carreta() {
        return placa_carreta;
    }

    public void setPlaca_carreta(String placa_carreta) {
        this.placa_carreta = placa_carreta;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion_falla() {
        return descripcion_falla;
    }

    public void setDescripcion_falla(String descripcion_falla) {
        this.descripcion_falla = descripcion_falla;
    }
}
