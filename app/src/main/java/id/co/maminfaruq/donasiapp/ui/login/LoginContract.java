package id.co.maminfaruq.donasiapp.ui.login;

import android.content.Context;

import id.co.maminfaruq.donasiapp.response.LoginResponse;

public interface LoginContract {
    interface View {
        void showProgress();
        void hideProgress();
        void onSuccess(String msg, LoginResponse data);
        void onFailed(String msg);
    }
    interface Presenter {
        void whenLogin(String username, String password);
        void session(Context context);
    }
}
