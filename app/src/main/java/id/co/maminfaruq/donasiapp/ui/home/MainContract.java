package id.co.maminfaruq.donasiapp.ui.home;

import android.content.Context;

public interface MainContract {
    interface View {
        void showProgress();
        void hideProgress();


    }
    interface Presenter {
        void logoutSession(Context context);
    }
}
