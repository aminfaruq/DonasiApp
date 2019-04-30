package id.co.maminfaruq.donasiapp.ui.register;

import id.co.maminfaruq.donasiapp.response.Data;

public interface RegisterContract {

    interface View{
        void showProggress();
        void hideProggress();
        void registerSuccess(String msg);
        void showError(String msg);

    }

    interface Presenter{
        void doRegisterUser(Data data);
    }
}
