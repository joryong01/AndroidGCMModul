package com.example.star_namu.androidgcmdemo_2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

public class MainActivity extends Activity {

    private String SENDER_ID = "60652789143";
    private GoogleCloudMessaging gcm;
    private String regid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gcm = GoogleCloudMessaging.getInstance(this);
        registerInBackground();
    }

    private void registerInBackground() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                try {
                    regid = gcm.register(SENDER_ID);
                    sendRegistrationIdToBackend();
                } catch (IOException ex) {
                }
                return "";
            }

            @Override
            protected void onPostExecute(String msg) {
            }
        }.execute(null, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void sendRegistrationIdToBackend() {
        // Your implementation here.
        Log.d(null, "RegId = " + regid);
    }
}