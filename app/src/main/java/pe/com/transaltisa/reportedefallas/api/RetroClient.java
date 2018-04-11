package pe.com.transaltisa.reportedefallas.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Pratik Butani
 */
public class RetroClient {

    /**
     * Upload URL of your folder with php file name...
     * You will find this file in php_upload folder in this project
     * You can copy that folder and paste in your htdocs folder...
     */
    //private static final String ROOT_URL = "http://169.254.187.11:8085/uploadimage/";
    private static final String ROOT_URL = "http://200.60.18.100:7001/RestApiReporteDeFallas/";
    //private static final String ROOT_URL = "http://172.20.6.214:8080/Hoteles-Rest-API/";
    //private static final String ROOT_URL = "http://172.20.1.168:8080/Hoteles-Rest-API/";
    //private static final String ROOT_URL = "http://172.20.1.168:7001/Reporte-0.2/";

    public RetroClient() {

    }

    /**
     * Get Retro Client
     *
     * @return JSON Object
     */
    private static Retrofit getRetroClient() {
        return new Retrofit.Builder()
                //.client(httpClient)
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetroClient().create(ApiService.class);
    }
}
