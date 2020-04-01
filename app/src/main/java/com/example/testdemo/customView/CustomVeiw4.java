package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.test.R;

public class CustomVeiw4 extends View {
    public CustomVeiw4(Context context) {
        super(context);
    }

    public CustomVeiw4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomVeiw4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;
    private Bitmap bitmap;
    private Rect src;
    private Rect dst;
    private int right = 0;

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5f);
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);

        src = new Rect(0, 0, right, bitmap.getHeight());
        dst = new Rect(0, 0, right, bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(bitmap, 100, 100, null);

        canvas.translate(250, 250);
        right += bitmap.getWidth() / 80;
        src.set(0, 0, right, bitmap.getHeight());
        dst.set(0, 0, right, bitmap.getHeight());

        canvas.drawBitmap(bitmap, src, dst, null);
        if (right < bitmap.getWidth()) {
            postInvalidateDelayed(10);
        }
    }


}
