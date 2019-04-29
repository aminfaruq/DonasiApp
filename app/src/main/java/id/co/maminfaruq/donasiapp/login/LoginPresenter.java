package id.co.maminfaruq.donasiapp.login;

import id.co.maminfaruq.donasiapp.network.ApiLoginClient;
import id.co.maminfaruq.donasiapp.network.ApiLoginInterface;
import id.co.maminfaruq.donasiapp.response.Data;
import id.co.maminfaruq.donasiapp.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;
    ApiLoginInterface apiLoginInterface = ApiLoginClient.getClient().create(ApiLoginInterface.class);

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void whenLogin(String email, String password) {
        if (email == null || email.isEmpty()) {
            view.onFailed("Email Anda Kosong !");
            return;
        }
        if (password == null || password.isEmpty()) {
            view.onFailed("Password Anda Kosong !");
            return;
        }
        view.showProggres();
       Call<LoginResponse> login = apiLoginInterface.loginUser(email, password);
       login.enqueue(new Callback<LoginResponse>() {
           @Override
           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               view.hideProggres();
               if (response.body() != null){
                   view.onSukses("Login Sukses", response.body());
               }
               if (response.body() == null){
                   view.hideProggres();
                   view.onFailed("Login Gagal");
               }
           }

           @Override
           public void onFailure(Call<LoginResponse> call, Throwable t) {
               view.hideProggres();
               view.onFailed("Login Anda Gagal .. ");
           }
       });
    }
}
