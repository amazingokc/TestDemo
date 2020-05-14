package com.example.testdemo.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //处理耗时任务
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }


}
