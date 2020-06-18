package com.example.testdemo.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.test.R;

public class RoundRelativelaout extends RelativeLayout {

    private float[] radius = new float[8];
    private boolean isCircle;

    private Path path;
    private Paint paint;

    public RoundRelativelaout(Context context) {
        super(context, null);
    }

    public RoundRelativelaout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundRelativelaout);
        radius[0] = typedArray.getDimensionPixelOffset(R.styleable.RoundRelativelaout_leftTopRadius, 0);
        radius[1] = radius[0];
        radius[2] = typedArray.getDimensionPixelOffset(R.styleable.RoundRelativelaout_rightTopRadius, 0);
        radius[3] = radius[2];
        radius[4] = typedArray.getDimensionPixelOffset(R.styleable.RoundRelativelaout_leftBottomRadius, 0);
        radius[5] = radius[4];
        radius[6] = typedArray.getDimensionPixelOffset(R.styleable.RoundRelativelaout_rightBottomRadius, 0);
        radius[7] = radius[6];
        isCircle = typedArray.getBoolean(R.styleable.RoundRelativelaout_isCircle, false);
        typedArray.recycle();

        init();
    }

    public RoundRelativelaout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        path = new Path();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        RectF rectF = new RectF();
        rectF.left = getPaddingLeft();
        rectF.top = getPaddingTop();
        rectF.right = w - getPaddingRight();
        rectF.bottom = h - getPaddingBottom();
        path.addRoundRect(rectF, radius, Path.Direction.CW);

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        // 绘制圆角
        canvas.clipPath(path);
        return super.drawChild(canvas, child, drawingTime);
    }

//    @Override
//    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
//        return super.drawChild(canvas, child, drawingTime);
//    }

//    @Override
//    protected void dispatchDraw(Canvas canvas) {
//        canvas.saveLayer(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), null, Canvas
//                .ALL_SAVE_FLAG);
//        super.dispatchDraw(canvas);
//        // 绘制带有圆角的 Path
//        canvas.drawPath(path, paint);
//        canvas.restore();
//    }
}
