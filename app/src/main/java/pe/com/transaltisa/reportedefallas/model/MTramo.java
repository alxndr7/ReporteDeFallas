package pe.com.transaltisa.reportedefallas.model;

/**
 * Created by CESAR-TRN on 3/04/2018.
 */

public class MTramo {
    int item;
    String tramo;

    public MTramo() {
    }

    public MTramo(int item, String tramo) {
        this.item = item;
        this.tramo = tramo;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }
}
