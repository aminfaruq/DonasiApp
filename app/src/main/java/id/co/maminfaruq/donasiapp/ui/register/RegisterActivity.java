package id.co.maminfaruq.donasiapp.ui.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import id.co.maminfaruq.donasiapp.R;
import id.co.maminfaruq.donasiapp.response.Data;
import id.co.maminfaruq.donasiapp.ui.login.LoginActivity;


public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {


    @BindView(R.id.ellipse)
    View ellipse;
    @BindView(R.id.edt_nama_reg)
    EditText edtNamaReg;
    @BindView(R.id.edt_email_reg)
    EditText edtEmailReg;
    @BindView(R.id.edt_nohp_reg)
    EditText edtNohpReg;
    @BindView(R.id.edt_username_reg)
    EditText edtUsernameReg;
    @BindView(R.id.edt_password_reg)
    EditText edtPasswordReg;
    @BindView(R.id.radioLaki)
    RadioButton radioLaki;
    @BindView(R.id.radioPerempuan)
    RadioButton radioPerempuan;
    @BindView(R.id.btn_signup_reg)
    Button btnSignupReg;


    private ProgressDialog progressDialog;
    private RegisterPresenter registerPresenter = new RegisterPresenter(this);
    String jenkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        setRadio();
    }

    private void setRadio() {
        if (radioLaki.isChecked()) {
            jenkel = "L";

        } else {
            jenkel = "P";
        }
    }


    @Override
    public void showProggress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void hideProggress() {
        progressDialog.dismiss();

    }

    @Override
    public void registerSuccess(String msg) {
        Toasty.success(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));

    }

    @Override
    public void showError(String msg) {
        Toasty.error(this, msg, Toasty.LENGTH_SHORT).show();
    }


    @OnClick({R.id.radioLaki, R.id.radioPerempuan, R.id.btn_signup_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioLaki:
                jenkel = "L";
                break;
            case R.id.radioPerempuan:
                jenkel = "P";
                break;
            case R.id.btn_signup_reg:

                Data mData = new Data();

                mData.setNamaUser(edtNamaReg.getText().toString());
                mData.setEmail(edtEmailReg.getText().toString());
                mData.setJenkel(jenkel);
                mData.setNoTelp(edtNohpReg.getText().toString());
                mData.setUsername(edtUsernameReg.getText().toString());
                mData.setPassword(edtPasswordReg.getText().toString());

                registerPresenter.doRegisterUser(mData);
                break;
        }
    }
}
