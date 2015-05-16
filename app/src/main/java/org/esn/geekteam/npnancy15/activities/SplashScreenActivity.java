package org.esn.geekteam.npnancy15.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.esn.geekteam.npnancy15.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spider on 28/04/15.
 */

public class SplashScreenActivity extends Activity {
    private static int SPLASH_TIME_OUT = 5000;
    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private Context context;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private GoogleCloudMessaging gcmObj;
    private String regId = "";
    private static final String GOOGLE_PROJ_ID = "697246358042";
    private static final String APP_SERVER_URL = "http://esnlille.fr/npnancy15/gcm.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        this.context = getApplicationContext();

        RegisterUser();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    // GCM
    public void RegisterUser() {
        if (checkPlayServices()) {
            registerInBackground();
        }
    }

    private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcmObj == null) {
                        gcmObj = GoogleCloudMessaging
                                .getInstance(context);
                    }
                    regId = gcmObj
                            .register(GOOGLE_PROJ_ID);
                    msg = "Registration ID :" + regId;
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                if (!TextUtils.isEmpty(regId)) {
                    new postRegID().execute();
                }
            }
        }.execute(null, null, null);
    }

    private class postRegID extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(APP_SERVER_URL);
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("regid", regId));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
            } catch (ClientProtocolException e) {
                Log.d(TAG,"ClientProtocolException" + e.getMessage());
            } catch (IOException e) {
                Log.d(TAG,"IOException" + e.getMessage());
            }

            return null;
        }

        protected void onPostExecute(Void args) {
            Log.d(TAG,"onPostExecute http sended");
        }
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                /*Toast.makeText(
                        context,
                        "This device doesn't support Play services, App will not work normally",
                        Toast.LENGTH_LONG).show();
                        */
                finish();
            }
            return false;
        } else {
            /*Toast.makeText(
                            context,
                            "This device supports Play services, App will work normally",
                            Toast.LENGTH_LONG).show();*/
        }
        return true;
    }

}