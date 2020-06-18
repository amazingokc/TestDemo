package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomVeiw1 extends View {
    public CustomVeiw1(Context context) {
        super(context);
    }

    public CustomVeiw1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomVeiw1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

//        canvas.drawPoint(100, 100, paint);
//        canvas.drawPoint(100, 400, paint);
//        canvas.drawPoint(100, 500, paint);
//        canvas.drawPoint(100, 600, paint);
//
//        canvas.drawPoints(new float[] {
//                300, 300,
//                300, 400,
//                300, 500
//        }, paint);

//        canvas.drawLine(100, 100,  200, 100, paint);
//        canvas.drawLine(100, 200,  200, 200, paint);
//        canvas.drawLine(300, 200,  500, 600, paint);

//        Rect rect = new Rect(100, 100, 300, 200);
//        canvas.drawRect(rect, paint);
//        RectF rectF = new RectF(100, 300, 300, 400);
//        canvas.drawRoundRect(rectF, 20, 20, paint);

//        paint.setColor(Color.GRAY);
//        canvas.drawRect(100, 100, 500, 300, paint);
//        paint.setColor(Color.RED);
//        RectF rectF = new RectF(100, 100, 500, 300);
//        canvas.drawOval(rectF, paint);

//        canvas.drawCircle(300,300, 100, paint);

//        paint.setColor(Color.GRAY);
//        canvas.drawRect(100, 100, 500, 300, paint);
//        paint.setColor(Color.RED);
//        RectF rectF = new RectF(100, 100, 500, 300);
//        canvas.drawArc(rectF, 0, 90, false, paint);

        paint.setStrokeWidth(50F);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,200, 100, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200,500, 100, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200,800, 100, paint);
    }
}
