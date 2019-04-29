package id.co.maminfaruq.donasiapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiLoginClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.70.77")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
        }
}