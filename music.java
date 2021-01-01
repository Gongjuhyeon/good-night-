package com.example.goodnightapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class music extends Service {
    MediaPlayer mp3;
    public music() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onCreate() {
        super.onCreate();
    }
    public void onDestroy() {

        mp3.stop();
        super.onDestroy();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp3 = MediaPlayer.create(this, R.raw.lullaby);
        mp3.setLooping(true);
        mp3.start();
        return super.onStartCommand(intent, flags, startId);
    }





}
