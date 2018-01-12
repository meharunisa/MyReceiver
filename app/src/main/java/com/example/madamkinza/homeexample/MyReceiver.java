package com.example.madamkinza.homeexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyReceiver extends AppCompatActivity {
private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level= intent.getIntExtra("level",0);
        ProgressBar pb=(ProgressBar)findViewById(R.id.progressBar);
        pb.setProgress(level);
        TextView tv= (TextView) findViewById(R.id.textView);
        tv.setText("battery level :" +Integer.toString(level));
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_receiver);
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
