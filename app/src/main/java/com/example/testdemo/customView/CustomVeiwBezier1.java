package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomVeiwBezier1 extends View {
    public CustomVeiwBezier1(Context context) {
        super(context);
    }

    public CustomVeiwBezier1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomVeiwBezier1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2f);
        paint.setAntiAlias(true);

        path = new Path();
    }

    private float width;
    private int height;
    private Path path;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        startX = (width / 2) - 400;
        startY = height / 2;
        endX = (width / 2) + 400;
        endY = height / 2;

        controlX1 = (width / 2) - 150;
        controlY1 = startY - 400;
        controlX2 = (width / 2) + 150;
        controlY2 = startY + 400;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.translate(width / 2, height / 2);

        //一阶贝塞尔曲线
//        path.moveTo(-200, 0);
//        path.quadTo(0, -150, 200, 0);

        //二阶贝塞尔曲线
        path.reset();
        path.moveTo(startX, startY);
        path.cubicTo(controlX1, controlY1, controlX2, controlY2, endX, endY);

        canvas.drawPath(path, paint);

    }

    private float startX;
    private float startY;
    private float endX;
    private float endY;

    //控制点1
    private float controlX1;
    private float controlY1;
    //控制点2
    private float controlX2;
    private float controlY2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getX() <= width / 2) {
            controlX1 = event.getX();
            controlY1 = event.getY();
        } else {
            controlX2 = event.getX();
            controlY2 = event.getY();
        }
        invalidate();
        return true;
    }
}
