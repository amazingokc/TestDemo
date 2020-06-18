package com.example.testdemo.viewDispatchEvent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.test.R;

/**
 * view的事件分发流程验证
 */
public class DispatchEventActivity extends AppCompatActivity {

    public static final String TAG = "dispatchEventlog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(DispatchEventActivity.TAG, "DispatchEventActivity-->" + "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(DispatchEventActivity.TAG, "DispatchEventActivity-->" + "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
