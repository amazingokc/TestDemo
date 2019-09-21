package com.example.testdemo.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.test.R;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-09-20 下午 4:54
 * 文件描述：
 */
public class onDrawTest extends View {
    public onDrawTest(Context context) {
        super(context);
    }

    public onDrawTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStrokeWidth(10);
        paint.setLinearText(true);
    }

    public onDrawTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public onDrawTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private Paint paint = new Paint();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getHeight()/2,getHeight()/2, getHeight()/2, paint);


    }
}
