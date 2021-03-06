package com.example.dell.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCustom = (Button) findViewById(R.id.buttonToCustomNotify);
        btnCustom.setOnClickListener(this);
        final Button btnNotify = (Button) findViewById(R.id.buttonToNotify);
        btnNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonToNotify:
                Log.i(MainActivity.TAG,"buttonToNotify Click" );
                triggerRegularNotification();
                break;
            case R.id.buttonToCustomNotify:
               Log.i(MainActivity.TAG,"buttonToCustomNotify Click" );
                triggerCustomNotification();
                break;

            default:
                Log.v(MainActivity.TAG,"Click item not set");
        }
    }

    private void triggerCustomNotification() {
        NotificationCompat.Builder mBuildes= (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.drawable.messenger_icon);
        RemoteViews mRemoteview=new RemoteViews(this.getPackageName(),R.layout.layout_custom_notification);
        mRemoteview.setImageViewResource(R.id.imageViewNotification,R.drawable.messenger_icon);
        mRemoteview.setTextViewText(R.id.txtViewTitle,this.getResources().getString(R.string.custom_notify_text_1));
        mRemoteview.setTextViewText(R.id.txtViewBody,this.getResources().getString(R.string.custom_notify_text_2));
        mRemoteview.setTextViewText(R.id.txtViewFootnote,this.getResources().getString(R.string.custom_notify_text_3));
       mBuildes.setContent(mRemoteview);
        NotificationManager mNotificationManager=(NotificationManager) this.getSystemService(Service.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mBuildes.build());

    }

    private void triggerRegularNotification() {
        NotificationCompat.Builder mBuildes= (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Warning")
                .setContentText("Auto Destruction ").setAutoCancel(true);
        Log.d(MainActivity.TAG,"triggerRegularNotification");
        Intent  mNotifiationInten = new Intent(this,Notification.class);
        PendingIntent mPendingIntent=PendingIntent.getActivity(this,1,mNotifiationInten,PendingIntent.FLAG_CANCEL_CURRENT);
        mBuildes.setContentIntent(mPendingIntent);
        NotificationManager mNotificationManager=(NotificationManager) this.getSystemService(Service.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mBuildes.build());

    }
}
