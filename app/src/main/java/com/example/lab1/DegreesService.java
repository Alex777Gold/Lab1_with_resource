package com.example.lab1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;


public class DegreesService extends Service {
    //teacher

    public static final String START = "START";
    public static final String STOP = "STOP";
    public static final String TIMER_ACTION = "TIMER_ACTION";



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getStringExtra(TIMER_ACTION);
        //long time = intent.getLongExtra(TIMER_TIME, 60000);

        if (START.equals(action)) {
            //startForeground(1, buildNotification());
            //startTimer(time);
        } else if (STOP.equals(action)) { //timer
            //stopTimer();
        }

        return START_STICKY;

    }
/*
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Started service", Toast.LENGTH_LONG).show();
        //logic
        return START_STICKY;
    }
    */

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Stoped service", Toast.LENGTH_LONG).show();
    }
}