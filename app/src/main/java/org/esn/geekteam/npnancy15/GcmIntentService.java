package org.esn.geekteam.npnancy15;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.esn.geekteam.npnancy15.activities.SplashScreenActivity;

import java.util.ArrayList;

/**
 * Created by Spider on 26/01/15.
 */
public class GcmIntentService extends IntentService {
    // Sets an ID for the notification, so it can be updated
    public static final int notifyID = 9001;
    static final String MSG_KEY = "m";
    static final String SBJ_KEY = "sbj";
    static final String SOUND_KEY = "sound";
    NotificationCompat.Builder builder;

    public GcmIntentService() {
        super("GcmIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {
            ArrayList<String> data = new ArrayList<String>();
            data.add(String.valueOf(extras.get(MSG_KEY)));
            data.add(String.valueOf(extras.get(SBJ_KEY)));
            data.add(String.valueOf(extras.get(SOUND_KEY)));

            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                    .equals(messageType)) {
                sendNotification("Send error: ",  data);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                    .equals(messageType)) {
                sendNotification("Deleted messages on server: ",
                        data);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                    .equals(messageType)) {
                sendNotification("Message", data);
            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void sendNotification(String error, ArrayList<String> data) {
        Intent resultIntent = new Intent(this, SplashScreenActivity.class);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(data.get(0))
                .setContentText(data.get(0))
                .setSmallIcon(R.mipmap.ic_launcher);

        // Set pending intent
        mNotifyBuilder.setContentIntent(resultPendingIntent);

        // Set Vibrate, Sound and Light
        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;

        Uri uri = null;


        if (data.get(2).equalsIgnoreCase("elephant")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elephant);
            mNotifyBuilder.setSound(uri);
        }
        else if (data.get(2).equalsIgnoreCase("reveil")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reveille);
            mNotifyBuilder.setSound(uri);
        }else if (data.get(2).equalsIgnoreCase("maison")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.maison);
            mNotifyBuilder.setSound(uri);
        }else if (data.get(2).equalsIgnoreCase("faispaschier")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.faispaschier);
            mNotifyBuilder.setSound(uri);
        }else if (data.get(2).equalsIgnoreCase("cyclisme")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cyclisme);
            mNotifyBuilder.setSound(uri);
        }else if (data.get(2).equalsIgnoreCase("adrienne")) {
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.adrienne);
            mNotifyBuilder.setSound(uri);
        }else{
            defaults = defaults | Notification.DEFAULT_SOUND;
        }
        mNotifyBuilder.setDefaults(defaults);

        // Set the content for Notification
        mNotifyBuilder.setContentText(data.get(1));
        // Set autocancel
        mNotifyBuilder.setAutoCancel(true);
        // Post a notification
        mNotificationManager.notify(notifyID, mNotifyBuilder.build());
    }
}
