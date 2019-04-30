package id.co.maminfaruq.donasiapp.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.maminfaruq.donasiapp.R;
import id.co.maminfaruq.donasiapp.utils.SessionManager;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;
    @BindView(R.id.txt_jenis_kelamin)
    TextView txtJenisKelamin;
    private TextView mTextMessage;
    private final MainPresenter presenter = new MainPresenter(this);
    private ProgressDialog progressDialog;
    SessionManager sm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sm = new SessionManager(MainActivity.this);

        HashMap<String, String> map = sm.getDetailLogin();

        txtNama.setText(map.get(sm.KEY_NAMA));
        txtJenisKelamin.setText(map.get(sm.KEY_JK));
        txtEmail.setText(map.get(sm.KEY_EMAIL));
        txtAlamat.setText(map.get(sm.KEY_ALAMAT));
        /*        imgFoto.setImageResource(Integer.parseInt(map.get(sm.KEY_FOTO)));*/

        sm.checkLogin();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(" Loading .. ");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                presenter.logoutSession(this);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
