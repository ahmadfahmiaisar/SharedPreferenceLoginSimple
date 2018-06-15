package com.bismillah.shareppreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPin = findViewById(R.id.et_pin);

        SharedPreferences sharedPreferences = getSharedPreferences("autentikasi", MODE_PRIVATE);

        if (sharedPreferences.getString("pin", "").isEmpty()){
            Intent intent = new Intent(this, SimpanPin.class);
            startActivity(intent);
            finish();
        }
    }

    public void cekPin(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("autentikasi", MODE_PRIVATE);

        if (etPin.getText().toString().isEmpty()){
            Toast.makeText(this, "di isi dulu PIN.nya", Toast.LENGTH_LONG).show();
        }
        String pinSp = sharedPreferences.getString("pin", "");
        String pin = etPin.getText().toString().trim();
        if (pin.equals(pinSp)){
            Intent intent = new Intent(this, SimpanPin.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "PIN.e salah cah", Toast.LENGTH_LONG).show();
        }
    }
}
