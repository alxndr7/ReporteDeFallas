package pe.com.transaltisa.reportedefallas.api;
import java.util.List;

import okhttp3.MultipartBody;
import pe.com.transaltisa.reportedefallas.api.response.Prueba;
import pe.com.transaltisa.reportedefallas.api.response.Result;
import retrofit2.Call;
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

    @POST("reportes-upload")
    @FormUrlEncoded
    Call<Result> pruebajson(@Field("titulo") String titulo,@Field("empresa") String empresa,
                                  @Field("reporteFecha") String reporteFecha,
                                  @Field("convoy") String convoy,@Field("placaTracto") String placaTracto,
                                  @Field("placaCarreta") String placaCarreta,@Field("kilometraje") String kilometraje,
                                  @Field("ubicacion") String ubicacion,@Field("descFalla") String descFalla,
                                    @Field("idUsuario") int idUsuario);
}
