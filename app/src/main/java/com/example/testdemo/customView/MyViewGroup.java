package com.example.testdemo.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.testdemo.LLog;

public class MyViewGroup extends RelativeLayout implements View.OnTouchListener {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        LLog.d("onTouchonTouch", "MyViewGroup:" + s);
        return false;
    }
}
