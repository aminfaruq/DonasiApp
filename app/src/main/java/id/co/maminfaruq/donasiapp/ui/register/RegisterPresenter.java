package id.co.maminfaruq.donasiapp.ui.register;

import android.util.Log;

import id.co.maminfaruq.donasiapp.network.ApiClient;
import id.co.maminfaruq.donasiapp.network.ApiInterface;
import id.co.maminfaruq.donasiapp.response.Data;
import id.co.maminfaruq.donasiapp.response.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter{

    RegisterContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void doRegisterUser(Data data) {

        if (data != null){
            if (!data.getNamaUser().isEmpty() &&
            !data.getEmail().isEmpty() &&
            !data.getJenkel().isEmpty() &&
            !data.getNoTelp().isEmpty() &&
            !data.getUsername().isEmpty() &&
            !data.getPassword().isEmpty()){



                view.showProggress();
                Call<LoginResponse> register = apiInterface.signupUser(
                        data.getNamaUser(),
                        data.getEmail(),
                        data.getJenkel(),
                        data.getNoTelp(),
                        data.getUsername(),
                        data.getPassword()
                );

                register.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        view.hideProggress();


                        if (response.body() != null){
                            if (response.body().getResult() == 1){
                                view.registerSuccess(response.body().getMessage());
                            } else {
                                view.showError(response.body().getMessage());
                            }
                        } else {
                            view.showError("Register gagal");
                            Log.d("RETRO", "onResponse: "+response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                        view.hideProggress();
                        view.showError(t.getMessage());
                    }
                });
            } else {
                view.showError("Tidak boleh kosong");
            }
        }

    }
}
