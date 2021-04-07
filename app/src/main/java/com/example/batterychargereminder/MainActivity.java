package com.example.batterychargereminder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Context;
import android.widget.Toast;

import javax.xml.datatype.DatatypeConstants;

import static javax.xml.datatype.DatatypeConstants.GREATER;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button stopbtn;
    Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        stopbtn = findViewById(R.id.stopbtn);
        ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));



                BroadcastReceiver broadcastReceiverBattrery = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Integer integerBatteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                        tv.setText(integerBatteryLevel.toString() + "%");
                        if (integerBatteryLevel > 99 ) {
                            ringtone.play();
                        }
                    }
                };
                registerReceiver(broadcastReceiverBattrery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            }


    public void stopButton(View view){

        ringtone.stop();

    }

}