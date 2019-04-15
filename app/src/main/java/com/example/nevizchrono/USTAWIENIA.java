package com.example.nevizchrono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class USTAWIENIA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawieni);
    }

    public void gotobluetooth(View view) {
        Intent intentbluetooth = new Intent(this, BLUETOOTH.class);
        startActivity(intentbluetooth);
    }
}
