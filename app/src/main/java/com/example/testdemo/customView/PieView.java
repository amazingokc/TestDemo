package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class PieView extends View {
    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        rectF = new RectF(100, 100, 500, 500);
    }

    private RectF rectF;
    private Integer[] datas = new Integer[]{40, 20, 10, 30};
    private Integer[] colors = new Integer[]{Color.YELLOW, Color.GREEN, Color.BLUE, Color.RED};
    private float startAngle = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < colors.length; i++) {
            paint.setColor(colors[i]);
            float sweepAngle = 360 * datas[i] / 100;
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
            startAngle = sweepAngle + startAngle;
        }


    }
}
