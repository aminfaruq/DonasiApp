package id.co.maminfaruq.donasiapp.ui.home;

import android.content.Context;

import id.co.maminfaruq.donasiapp.utils.SessionManager;

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void logoutSession(Context context) {
        SessionManager sessionManager = new SessionManager(context);
        sessionManager.logout();
    }
}
