package id.co.maminfaruq.donasiapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.71.174/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
        }
}
