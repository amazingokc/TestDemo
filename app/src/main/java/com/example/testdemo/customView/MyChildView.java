package com.example.testdemo.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.testdemo.LLog;

public class MyChildView extends View implements View.OnTouchListener{
    public MyChildView(Context context) {
        super(context);
    }

    public MyChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);

//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public MyChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String s = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                s = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                s = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                s = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                s = "ACTION_CANCEL";
                break;
        }
        LLog.d("onTouchonTouch", "MyChildView:" + s);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
