package com.example.backgroundtaskapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager mManager;
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {

            createChannel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {


            NotificationChannel channel = new NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH);

            getmManager().createNotificationChannel(channel);





    }


    public NotificationManager getmManager() {
        if (mManager == null) {
            mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }


    public NotificationCompat.Builder getChannelNotification() {

        return new NotificationCompat.Builder(
                getApplicationContext(),
                channelID

        )
                .setContentTitle("Alarm")
                .setContentText("Your AlarmManager is working")
                .setSmallIcon(R.drawable.ic_android);

    }







}
