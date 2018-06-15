package com.bismillah.shareppreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SimpanPin extends AppCompatActivity {

    EditText etSimpanPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpan_pin);
    etSimpanPin = findViewById(R.id.et_simpan_pin);
    }

    public void simpanPin(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("autentikasi", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (etSimpanPin.getText().toString().isEmpty()){
            editor.remove("pin");
            editor.commit();
            Toast.makeText(this, "Pin jadinya kosong", Toast.LENGTH_LONG).show();
            return;
        }

        String simpanPIn = etSimpanPin.getText().toString().trim();
        editor.putString("pin", simpanPIn);
        editor.commit();
        Toast.makeText(this, "Pin udah tersimpan", Toast.LENGTH_LONG).show();
    }
}
