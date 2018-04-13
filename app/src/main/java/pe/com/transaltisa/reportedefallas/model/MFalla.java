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
    private String ruta;
    private String empresa;
    private String flota;
    private String convoy;
    private String placa_tracto;
    private String placa_carreta;
    private String kilometraje;
    private String ubicacion;
    private String descripcion_falla;
    private String nombre_image1;
    private byte[] image;
    private byte[] image2;
    private byte[] image3;
    private String id_usuario;
    private String estado;
    private String estado_envio;

    public MFalla(){
    }

    public MFalla(int id_falla, String titulo, String fecha_falla, String hora_falla, String ruta, String empresa, String flota, String convoy, String placa_tracto, String placa_carreta, String kilometraje, String ubicacion, String descripcion_falla, String nombre_image1, byte[] image, byte[] image2, byte[] image3, String id_usuario, String estado, String estado_envio) {
        this.id_falla = id_falla;
        this.titulo = titulo;
        this.fecha_falla = fecha_falla;
        this.hora_falla = hora_falla;
        this.ruta = ruta;
        this.empresa = empresa;
        this.flota = flota;
        this.convoy = convoy;
        this.placa_tracto = placa_tracto;
        this.placa_carreta = placa_carreta;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.descripcion_falla = descripcion_falla;
        this.nombre_image1 = nombre_image1;
        this.image = image;
        this.image2 = image2;
        this.image3 = image3;
        this.id_usuario = id_usuario;
        this.estado = estado;
        this.estado_envio = estado_envio;
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

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public String getNombre_image1() {
        return nombre_image1;
    }

    public void setNombre_image1(String nombre_image1) {
        this.nombre_image1 = nombre_image1;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getImage3() {
        return image3;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    @Override
    public String toString() {
        return "MFalla{" +
                "id_falla=" + id_falla +
                ", titulo='" + titulo + '\'' +
                ", fecha_falla='" + fecha_falla + '\'' +
                ", hora_falla='" + hora_falla + '\'' +
                ", ruta='" + ruta + '\'' +
                ", empresa='" + empresa + '\'' +
                ", flota='" + flota + '\'' +
                ", convoy='" + convoy + '\'' +
                ", placa_tracto='" + placa_tracto + '\'' +
                ", placa_carreta='" + placa_carreta + '\'' +
                ", kilometraje='" + kilometraje + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", descripcion_falla='" + descripcion_falla + '\'' +
                ", id_usuario='" + id_usuario + '\'' +
                ", estado='" + estado + '\'' +
                ", estado_envio='" + estado_envio + '\'' +
                '}';
    }
}
