package id.co.maminfaruq.donasiapp.ui.login;

import android.content.Context;

import java.util.List;

import id.co.maminfaruq.donasiapp.network.ApiClient;
import id.co.maminfaruq.donasiapp.network.ApiInterface;
import id.co.maminfaruq.donasiapp.response.Data;
import id.co.maminfaruq.donasiapp.response.LoginResponse;
import id.co.maminfaruq.donasiapp.ui.login.LoginContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }
    @Override
    public void session(Context context) {

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
        view.showProgress();
        Call<LoginResponse> login = apiInterface.loginUser(email, password);
        login.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                view.hideProgress();
                /*LoginResponse res = response.body();*/
               /* List<Data> user = res.getData();*/
                if (response.body() != null) {

                    if (response.body().getResult() == 1) {
                        /*sm.storeLogin(user.get(0).getNamaUser(),user.get(0).getJenkel(),user.get(0).getNoTelp(),user.get(0).getEmail());*/
                        view.onSuccess("Login Sukses", response.body());
                    }else {
                        view.onFailed(" Login gagal");
                    }
                }else {
                    view.onFailed(" data kosong");
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.hideProgress();
                view.onFailed("Login Anda Gagal .. ");
            }
        });
    }


}
