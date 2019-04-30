package id.co.maminfaruq.donasiapp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.ellipse)
    View ellipse;
    @BindView(R.id.edtnama)
    EditText edtnama;
    @BindView(R.id.edtnotelp)
    EditText edtnotelp;
    @BindView(R.id.edtusername)
    EditText edtusername;
    @BindView(R.id.edtpassword)
    TextInputEditText edtpassword;
    @BindView(R.id.edtemail)
    TextInputEditText edtemail;
    @BindView(R.id.btnregister)
    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnregister)
    public void onViewClicked() {

    }
}
