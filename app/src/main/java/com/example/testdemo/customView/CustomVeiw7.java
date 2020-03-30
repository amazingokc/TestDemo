package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.testdemo.LLog;

public class CustomVeiw7 extends View {
    public CustomVeiw7(Context context) {
        super(context);
    }

    public CustomVeiw7(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomVeiw7(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint kuangPaint;

    private void init() {
        kuangPaint = new Paint();
        kuangPaint.setAntiAlias(true);
        kuangPaint.setColor(Color.BLACK);
        kuangPaint.setStyle(Paint.Style.STROKE);
        kuangPaint.setStrokeWidth(3f);

    }

    private int width;
    private int height;
    private int valueTypeCount = 6;
    private int bigRadius;
    private float angle = (float) (2 * Math.PI / valueTypeCount);


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        bigRadius = width / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(width / 2, height / 2);
        drawKuang(canvas);
    }

    private void drawKuang(Canvas canvas) {
        Path path = new Path();
        int radius;

        for (int i = 1; i <= 5; i++) {
            radius = i * bigRadius / 5;
            path.reset();

            for (int j = 0; j < valueTypeCount; j++) {
                if (j == 0) {
                    path.moveTo(radius, 0);
                } else {
                    float x = (float) (radius * Math.cos(angle * j));
                    float y = (float) (radius * Math.sin(angle * j));

                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, kuangPaint);

        }

    }

}
