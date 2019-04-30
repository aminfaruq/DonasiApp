package id.co.maminfaruq.donasiapp.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import es.dmoral.toasty.Toasty;
import id.co.maminfaruq.donasiapp.MainActivity;
import id.co.maminfaruq.donasiapp.R;
import id.co.maminfaruq.donasiapp.response.LoginResponse;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    ProgressDialog progressDialog;
    LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess(String msg, LoginResponse loginResponse) {
        Toasty.success(this,"Login Anda Berhasil", Toasty.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onFailed(String msg) {
        Toasty.error(this, " Login Anda Gagal", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginPresenter.whenLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
    }
}
