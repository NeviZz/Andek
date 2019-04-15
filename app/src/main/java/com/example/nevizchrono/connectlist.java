package com.example.nevizchrono;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

import androidx.annotation.Nullable;

public class connectlist extends ListActivity {

    private BluetoothAdapter mBluetoothAdapter = null;

    static String adress_mac = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> ArrayBluetooth = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> dostepneurzadzenia = mBluetoothAdapter.getBondedDevices();



        if(dostepneurzadzenia.size() > 0){
            for (BluetoothDevice dyspozycje : dostepneurzadzenia){
                String nameBt = dyspozycje.getName();
                String macBt = dyspozycje.getAddress();
                ArrayBluetooth.add(nameBt + "\n" + macBt);
            }
        }

        setListAdapter(ArrayBluetooth);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String general = ((TextView)v).getText().toString();

        //Toast.makeText(getApplicationContext(), "Info: " + general, Toast.LENGTH_LONG).show();

        String endmac = general.substring(general.length() - 17);

        //Toast.makeText(getApplicationContext(), "Mac: " + endmac, Toast.LENGTH_LONG).show();

        Intent remac = new Intent();
        remac.putExtra(adress_mac, endmac);
        setResult(RESULT_OK, remac);
        finish();
    }
}
