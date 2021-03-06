package id.co.maminfaruq.donasiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.maminfaruq.donasiapp.ui.login.LoginActivity;
import id.co.maminfaruq.donasiapp.ui.register.RegisterActivity;

public class HalamanAwalActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.donasiku)
    TextView donasiku;
    @BindView(R.id.sharing_is_)
    TextView sharingIs;
    @BindView(R.id.lopelope)
    View ellipse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_signup, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signup:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
