package pe.com.transaltisa.reportedefallas.api;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.com.transaltisa.reportedefallas.api.response.Prueba;
import pe.com.transaltisa.reportedefallas.api.response.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @author Pratik Butani on 23/4/16.
 */
public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of Contacts
    */
    @Multipart
    @POST("reportes-upload")
    Call<Result> pruebajson(@Part("titulo") RequestBody titulo,@Part("empresa") RequestBody empresa,
                            @Part("ruta") RequestBody ruta,
                            @Part("reporteFecha") RequestBody reporteFecha, @Part("flota") RequestBody flota,
                            @Part("convoy") RequestBody convoy,@Part("placaTracto") RequestBody placaTracto,
                            @Part("placaCarreta") RequestBody placaCarreta,@Part("kilometraje") RequestBody kilometraje,
                            @Part("ubicacion") RequestBody ubicacion,@Part("descFalla") RequestBody descFalla,
                            @Part("idUsuario") RequestBody idUsuario,
                            @Part("imageBody") RequestBody imageBody);

   /* Call<Result> pruebajson(@Part("titulo") String titulo,@Part("empresa") String empresa,
                            @Part("ruta") String ruta,
                            @Part("reporteFecha") String reporteFecha, @Part("flota") String flota,
                            @Part("convoy") String convoy,@Part("placaTracto") String placaTracto,
                            @Part("placaCarreta") String placaCarreta,@Part("kilometraje") String kilometraje,
                            @Part("ubicacion") String ubicacion,@Part("descFalla") String descFalla,
                            @Part("idUsuario") String idUsuario);*/

  /*  Call<Result> pruebajson(@Part("titulo") String titulo,@Part("empresa") RequestBody empresa,
                            @Part("ruta") RequestBody ruta,
                            @Part("reporteFecha") RequestBody reporteFecha, @Part("flota") RequestBody flota,
                            @Part("convoy") RequestBody convoy,@Part("placaTracto") RequestBody placaTracto,
                            @Part("placaCarreta") RequestBody placaCarreta,@Part("kilometraje") RequestBody kilometraje,
                            @Part("ubicacion") RequestBody ubicacion,@Part("descFalla") RequestBody descFalla,
                            @Part("idUsuario") RequestBody idUsuario,
                            @Part MultipartBody.Part imageBody);*/

/*    Call<Result> pruebajson(@Part("titulo") String titulo,@Part("empresa") String empresa,
                            @Part("ruta") String ruta,
                            @Part("reporteFecha") String reporteFecha, @Part("flota") String flota,
                            @Part("convoy") String convoy,@Part("placaTracto") String placaTracto,
                            @Part("placaCarreta") String placaCarreta,@Part("kilometraje") String kilometraje,
                            @Part("ubicacion") String ubicacion,@Part("descFalla") String descFalla,
                            @Part("idUsuario") int idUsuario);*/
}
