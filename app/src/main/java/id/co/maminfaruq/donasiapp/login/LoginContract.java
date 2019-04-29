package id.co.maminfaruq.donasiapp.login;

import id.co.maminfaruq.donasiapp.response.Data;
import id.co.maminfaruq.donasiapp.response.LoginResponse;

public interface LoginContract {
    interface View {
        void showProggres();
        void hideProggres();
        void onSukses(String msg, LoginResponse data);
        void onFailed(String msg);
    }
    interface Presenter {
        void whenLogin(String username, String password);
    }
}
