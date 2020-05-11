package com.example.testdemo.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView8 extends View {
    public CustomView8(Context context) {
        super(context);
    }

    public CustomView8(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView8(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(350, 350);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(350, heightMeasureSpec);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpec, 350);
        }

    }
}
