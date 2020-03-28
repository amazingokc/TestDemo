package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomVeiw2 extends View {
    public CustomVeiw2(Context context) {
        super(context);
    }

    public CustomVeiw2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomVeiw2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;
    private RectF rectF;

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        rectF = new RectF(0, -400, 400, 0);
    }

    private int width;
    private int height;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        paint.setColor(Color.BLACK);
//        canvas.drawCircle(200, 200,50, paint);
//        paint.setColor(Color.BLUE);
//        canvas.translate(400, 400);
//        canvas.drawCircle(0, 0,50, paint);

        paint.setColor(Color.BLACK);
        canvas.translate(width / 2, height / 2);

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.scale(0.5f, 0.5f, 0,0);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.scale(0.5f, 0.5f, 200,0);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.scale(-0.5f, -0.5f, 0,0);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.scale(-0.5f, -0.5f, 200,0);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        for (int i = 0; i < 15; i++) {
//            canvas.scale(0.9f, 0.9f, 200,-200);
//            canvas.drawRect(rectF, paint);
//        }

//        canvas.drawRect(rectF, paint);
//        canvas.rotate(180);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        canvas.rotate(180, 200,0);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(rectF, paint);

//        canvas.drawCircle(0, 0, 200, paint);
//        canvas.drawCircle(0, 0, 190, paint);
//        canvas.drawLine(0, 200, 0, 190, paint);
//        for (int i = 10; i <= 360; i = i + 10) {
//            canvas.drawLine(0, 200, 0, 190, paint);
//            canvas.rotate(10, 0, 0);
//        }

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.skew(1,0);
//        canvas.drawRect(rectF, paint);

//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.skew(1,0);
//        canvas.skew(0,1);
//        canvas.drawRect(rectF, paint);

    }
}
