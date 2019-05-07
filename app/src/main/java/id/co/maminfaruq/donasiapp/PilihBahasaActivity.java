package id.co.maminfaruq.donasiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PilihBahasaActivity extends AppCompatActivity {

    Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_bahasa);

        btnIntent = findViewById(R.id.btnBahasa);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihBahasaActivity.this, SemogaBisaPindah.class);
                startActivity(intent);
            }
        });


    }
}
