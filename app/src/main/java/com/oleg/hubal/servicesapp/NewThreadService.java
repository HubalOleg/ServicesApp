package com.oleg.hubal.servicesapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by User on 20.12.2016.
 */

public class NewThreadService extends IntentService {
    private static final String TAG = "NewThreadService";

    public NewThreadService() {
        super("NewThreadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, Thread.currentThread().getName());
    }
}
