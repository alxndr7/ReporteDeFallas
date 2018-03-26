package pe.com.transaltisa.reportedefallas.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("result")
    @Expose
    private String mensaje;

    /**
     * @return The result
     */
    public String getResult() {
        return mensaje;
    }

    /**
     * @param mensaje The result
     */
    public void setResult(String mensaje) {
        this.mensaje = mensaje;
    }

}