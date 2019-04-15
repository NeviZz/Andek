package com.example.nevizchrono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class JOUL extends AppCompatActivity {
    private static SeekBar seek_bar;
    private static TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joul);
        seekbar();
    }

    public void seekbar(){
        seek_bar = (SeekBar)findViewById(R.id.seekBarjoul);
        text_view = (TextView)findViewById(R.id.textViewjoul);
        text_view.setText("Waga: 0." + seek_bar.getProgress() + " grama");

        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int proggress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        proggress_value = progress;
                        text_view.setText("Waga: 0." + progress + " grama");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        text_view.setText("Waga: 0." + proggress_value + " grama");

                    }
                }
        );
    }



}
