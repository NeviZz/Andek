package com.example.nevizchrono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoustawienia(View view) {
        Intent intentustawienia = new Intent(this, USTAWIENIA.class);
        startActivity(intentustawienia);
    }

    public void gotomns(View view) {
        Intent intentmns = new Intent(this, MNS.class);
        startActivity(intentmns);
    }

    public void gotojoul(View view) {
        Intent intentjoul = new Intent(this, JOUL.class);
        startActivity(intentjoul);
    }

    public void gotofps(View view) {
        Intent intentfps = new Intent(this, FPS.class);
        startActivity(intentfps);
    }

    public void gotorof(View view) {
        Intent intentrof = new Intent(this, rof.class);
        startActivity(intentrof);
    }
}
