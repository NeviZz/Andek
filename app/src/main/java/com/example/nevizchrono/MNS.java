package com.example.nevizchrono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MNS extends AppCompatActivity {
    private static SeekBar seek_bar;
    private static TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mns);
        seekbar();
    }


    public void seekbar(){
        seek_bar = (SeekBar)findViewById(R.id.seekBarmns);
        text_view = (TextView)findViewById(R.id.textViewmns);
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
