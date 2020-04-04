package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

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

    private Paint blackLinesPaint;
    private Paint valuePaint;
    private Paint pointPaint;
    private Paint valueTypePaint;

    private void init() {
        path = new Path();

        blackLinesPaint = new Paint();
        blackLinesPaint.setAntiAlias(true);
        blackLinesPaint.setColor(Color.BLACK);
        blackLinesPaint.setStyle(Paint.Style.STROKE);
        blackLinesPaint.setStrokeWidth(2f);

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true);
        valuePaint.setColor(Color.BLUE);
        valuePaint.setStyle(Paint.Style.FILL);
        valuePaint.setStrokeWidth(1.5f);
        valuePaint.setAlpha(150);

        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setColor(Color.BLUE);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setStrokeWidth(1.5f);

        valueTypePaint = new Paint();
        valueTypePaint.setAntiAlias(true);
        valueTypePaint.setColor(Color.BLACK);
        valueTypePaint.setStyle(Paint.Style.FILL);
        valueTypePaint.setTextSize(30);
        valueTypePaint.setStrokeWidth(2f);
    }

    private float width;
    private float height;
    private float valueTypeCount = 6;
    private float bigRadius;
    private float angle = (float) (2 * Math.PI / valueTypeCount);
    private float[] values = new float[]{77, 50, 90, 55, 60, 86};
    private String[] valuesType = new String[]{"AAA", "BBB", "CCC", "DDD", "EEE", "FFF"};

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        bigRadius = width / 2.5f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, height / 2);
        drawKuang(canvas);
        drawLines(canvas);
        drawValus(canvas);
        drawValueType(canvas);
    }

    private Path path;

    //画框
    private void drawKuang(Canvas canvas) {
        float radius;
        for (int i = 1; i <= 5; i++) {
            radius = i * bigRadius / 5;

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
            canvas.drawPath(path, blackLinesPaint);
        }
    }

    //画线
    private void drawLines(Canvas canvas) {
        path.moveTo(-bigRadius / 2, 0);
        path.lineTo(bigRadius / 2, 0);
        canvas.drawPath(path, blackLinesPaint);

        for (int i = 0; i < valueTypeCount; i++) {
            path.moveTo(0, 0);
            float x = (float) (bigRadius * Math.cos(angle * i));
            float y = (float) (bigRadius * Math.sin(angle * i));
            path.lineTo(x, y);
            canvas.drawPath(path, blackLinesPaint);
        }
    }

    //画数值区域
    private void drawValus(Canvas canvas) {
        path.reset();
        for (int i = 0; i < valueTypeCount; i++) {
            float maxValue = 100;
            float x = (float) ((values[i] / maxValue) * bigRadius * Math.cos(angle * i));
            float y = (float) ((values[i] / maxValue) * bigRadius * Math.sin(angle * i));
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 10, pointPaint);
        }
        path.close();
        canvas.drawPath(path, valuePaint);
    }

    //画数值类型
    private void drawValueType(Canvas canvas) {
        int dis = 10;
        Paint.FontMetrics fontMetrics = valueTypePaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;

        for (int i = 0; i < valueTypeCount; i++) {
            float x = (float) (bigRadius * Math.cos(angle * i));
            float y = (float) (bigRadius * Math.sin(angle * i));

            //这个10是作为计算误差补偿
            if (y > 10) {
                canvas.drawText(valuesType[i], x, y + fontHeight, valueTypePaint);
            } else if (y < -10) {
                canvas.drawText(valuesType[i], x, y - dis, valueTypePaint);
            } else {
                if (x < -10) {
                    float fontWith = valueTypePaint.measureText(valuesType[i]);//文本长度
                    canvas.drawText(valuesType[i], x - fontWith- dis, y, valueTypePaint);
                } else if (x > -10) {
                    canvas.drawText(valuesType[i], x + dis, y, valueTypePaint);
                }
            }
        }
    }




}
