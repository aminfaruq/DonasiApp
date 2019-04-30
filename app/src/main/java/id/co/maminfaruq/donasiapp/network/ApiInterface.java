package id.co.maminfaruq.donasiapp.network;

import id.co.maminfaruq.donasiapp.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("donasi_app/login_user.php")
    Call<LoginResponse> loginUser(
            @Field("username") String email,
            @Field("password") String pass
    );
}
