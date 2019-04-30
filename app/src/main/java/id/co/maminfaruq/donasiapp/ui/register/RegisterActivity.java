package id.co.maminfaruq.donasiapp.ui.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.maminfaruq.donasiapp.R;


public class RegisterActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_signup_reg)
    public void onViewClicked() {
    }
}
