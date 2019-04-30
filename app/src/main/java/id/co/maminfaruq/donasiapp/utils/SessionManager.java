package id.co.maminfaruq.donasiapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import id.co.maminfaruq.donasiapp.ui.home.MainActivity;
import id.co.maminfaruq.donasiapp.ui.login.LoginActivity;

public class SessionManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public static final String KEY_NAMA = "nama";
    public static final String KEY_JK = "jk";
    public static final String KEY_ALAMAT = "no_telp";
    public static final String KEY_EMAIL = "email";
    private static final String is_login = "logginstatus";
    private final String SHARE_NAME = "loginsession";
    private final int MODE_PRIVATE = 0;
    private final Context context;

    public SessionManager(Context context) {
        this.context = context;

        sp = context.getSharedPreferences(SHARE_NAME,MODE_PRIVATE);
        editor = sp.edit();
    }

    public void storeLogin(String nama, String jk, String alamat, String email)
    {
        editor.putBoolean(is_login,true);
        editor.putString(KEY_NAMA,nama);
        editor.putString(KEY_JK,jk);
        editor.putString(KEY_ALAMAT,alamat);
        editor.putString(KEY_EMAIL,email);

        editor.commit();

    }

    public HashMap getDetailLogin()
    {
        HashMap<String,String> map = new HashMap<>();
        map.put(KEY_NAMA, sp.getString(KEY_NAMA, null));
        map.put(KEY_JK, sp.getString(KEY_JK, null));
        map.put(KEY_ALAMAT, sp.getString(KEY_ALAMAT, null));
        map.put(KEY_EMAIL, sp.getString(KEY_EMAIL, null));

        return map;

    }

    public void checkLogin()
    {
        if (!this.Loggin())
        {
            Intent login = new Intent(context, MainActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(login);
        }
    }

    private boolean Loggin() {
        return sp.getBoolean(is_login,false);
    }

   /* public void logout() {
        editor.clear();
        editor.clear();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/
}
