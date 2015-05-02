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
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

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
        String msg = String.valueOf(extras.get(MSG_KEY));
        String sbj = String.valueOf(extras.get(SBJ_KEY));
        String sound = String.valueOf(extras.get(SOUND_KEY));

        Log.d("PUSH", "sound : " + sound);

        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                    .equals(messageType)) {
                sendNotification("Send error: ",  extras.toString(), sound);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                    .equals(messageType)) {
                sendNotification("Deleted messages on server: ",
                         extras.toString(), sound);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                    .equals(messageType)) {
                sendNotification(sbj, msg, sound);
            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    private void sendNotification(String sbj, String msg, String sound) {
        Intent resultIntent = new Intent(this, SplashScreenActivity.class);
        resultIntent.putExtra("title", msg);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(sbj)
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher);

        // Set pending intent
        mNotifyBuilder.setContentIntent(resultPendingIntent);

        // Set Vibrate, Sound and Light
        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;

        Uri uri = null;
        if (sound.equalsIgnoreCase("elephant")) {
            Log.d("PUSH", "url");
            uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elephant);
            mNotifyBuilder.setSound(uri);
        }else{
            Log.d("PUSH", "default");
            defaults = defaults | Notification.DEFAULT_SOUND;
        }
        mNotifyBuilder.setDefaults(defaults);

        // Set the content for Notification
        mNotifyBuilder.setContentText(msg);
        // Set autocancel
        mNotifyBuilder.setAutoCancel(true);
        // Post a notification
        mNotificationManager.notify(notifyID, mNotifyBuilder.build());
    }
}
