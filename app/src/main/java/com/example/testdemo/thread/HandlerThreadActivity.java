package com.example.testdemo.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;
import com.example.testdemo.LLog;

/**
 * 子线程的looper在不使用的时候需要quit（），才能释放子线程，否则子线程将会一直运行
 * */
public class HandlerThreadActivity extends AppCompatActivity {

    private HandlerThread handlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

//        handlerThread = new HandlerThread("MyHandlerThread");
//        handlerThread.start();
//
//
//        handler = new Handler(handlerThread.getLooper()) {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                //处理耗时任务
//            }
//        };


        //return可以终止循环
//        for (;;) {
//            LLog.d("qweewqeqwe", "11");
//            String a = null;
//            if (a == null) {
//                return;
//            }
//        }

        myThread = new MyThread("MyThrea");
        myThread.start();


    }

    private Handler handler = null;

    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        handlerThread.quit();

        myThread.looper.quit();
    }

    private MyThread myThread;

    class MyThread extends Thread {

        public Looper looper;

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            looper = Looper.myLooper();
            Looper.loop();

            handler = new Handler(myThread.looper) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    LLog.d("dadsadaaaaaaa", "11");
                }
            };

        }


    }


}
