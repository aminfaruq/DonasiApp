package id.co.maminfaruq.donasiapp.ui.home;

import android.content.Context;

import java.util.HashMap;

import id.co.maminfaruq.donasiapp.utils.SessionManager;

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


    @Override
    public void logoutSession(Context context) {
        SessionManager sm = new SessionManager(context);

        HashMap<String, String> map = sm.getDetailLogin();
        sm.checkLogin();
    }
}
