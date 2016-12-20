package com.oleg.hubal.servicesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Intent mServiceIntent;

    @BindView(R.id.btn_main_thread_service)
    Button mMainThreadServiceButton;
    @BindView(R.id.btn_new_thread_service)
    Button mNewThreadServiceButton;
    @BindView(R.id.btn_service_new_process)
    Button mServiceNewThreadButton;

    private View.OnClickListener mOnMainThreadServiceClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopServices();
            mServiceIntent = new Intent(MainActivity.this, MainThreadService.class);
            startService(mServiceIntent);
        }
    };

    private View.OnClickListener mOnNewThreadServiceClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopServices();
            mServiceIntent = new Intent(MainActivity.this, NewThreadService.class);
            startService(mServiceIntent);
        }
    };

    private View.OnClickListener mOnNewProcessServiceClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            stopServices();
            mServiceIntent = new Intent(MainActivity.this, NewProcessService.class);
            startService(mServiceIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, Process.getThreadPriority(Process.myTid()) + "");

        ButterKnife.bind(MainActivity.this);

        mMainThreadServiceButton.setOnClickListener(mOnMainThreadServiceClick);
        mNewThreadServiceButton.setOnClickListener(mOnNewThreadServiceClick);
        mServiceNewThreadButton.setOnClickListener(mOnNewProcessServiceClick);
    }

    private void stopServices() {
        if (mServiceIntent != null) {
            stopService(mServiceIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
