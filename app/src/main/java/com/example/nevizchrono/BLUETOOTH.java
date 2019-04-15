package com.example.nevizchrono;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BLUETOOTH extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_CONNECT = 2;


    TextView mStatusBlueTv;
    ImageView mBlueIv;
    Button mOnBtn, mOffBtn, mConnect;

    BluetoothAdapter mBlueAdapter;

    boolean connnect = false;

    private static String MAC = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);


        mStatusBlueTv = findViewById(R.id.ststusbt);
        mBlueIv = findViewById(R.id.bluetoothIv);
        mOnBtn = findViewById(R.id.onBt);
        mOffBtn = findViewById(R.id.offBt);
        mConnect = findViewById(R.id.bconnectbtn);


        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBlueAdapter == null) {

            mStatusBlueTv.setText("Bluetooth is not available");
        } else {
            mStatusBlueTv.setText("Bluetooth is available");
        }

        if (mBlueAdapter.isEnabled()) {
            mBlueIv.setImageResource(R.drawable.ic_action_on);
            mOnBtn.setVisibility(View.GONE);
            mOffBtn.setVisibility(View.VISIBLE);
            mConnect.setVisibility(View.VISIBLE);
        } else {
            mBlueIv.setImageResource(R.drawable.ic_action_off);
            mOffBtn.setVisibility(View.GONE);
            mOnBtn.setVisibility(View.VISIBLE);
            mConnect.setVisibility(View.GONE);
        }

        //on btn click

        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBlueAdapter.isEnabled()) {
                    showToast("Turning On Bluetooth...");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                    mOnBtn.setVisibility(View.GONE);
                    mOffBtn.setVisibility(View.VISIBLE);
                    mConnect.setVisibility(View.VISIBLE);
                } else {
                    mOffBtn.setVisibility(View.VISIBLE);
                    mOnBtn.setVisibility(View.GONE);
                    mConnect.setVisibility(View.VISIBLE);
                    showToast("Bluetooth is already on");

                }
            }
        });


        mOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBlueAdapter.isEnabled()) {
                    mBlueAdapter.disable();
                    showToast("Turning Bluetooth Off");
                    mBlueIv.setImageResource(R.drawable.ic_action_off);
                    mOffBtn.setVisibility(View.GONE);
                    mOnBtn.setVisibility(View.VISIBLE);
                    mConnect.setVisibility(View.GONE);
                } else {
                    mOnBtn.setVisibility(View.VISIBLE);
                    mOffBtn.setVisibility(View.GONE);
                    mConnect.setVisibility(View.GONE);
                    showToast("Bluetooth is already off");
                }
            }
        });





        mConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (connnect) {

                } else {
                    Intent Lista = new Intent(BLUETOOTH.this, connectlist.class);
                    startActivityForResult(Lista, REQUEST_CONNECT);

                }
            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if(resultCode == RESULT_OK){
                    mBlueIv.setImageResource(R.drawable.ic_action_on);
                    showToast("Bluetooth is on");
                }else{
                    showToast("Could't on bluetooth");
                    finish();
                }
                break;

            case REQUEST_CONNECT:
                if(resultCode == Activity.RESULT_OK){
                    MAC = data.getExtras().getString(connectlist.adress_mac);

                    showToast("MAC finall: " + MAC);
                }else{
                    showToast("Could't download MAC");
                }



        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showToast (String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
