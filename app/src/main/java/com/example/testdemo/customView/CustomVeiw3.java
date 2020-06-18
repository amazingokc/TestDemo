package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomVeiw3 extends View {
    public CustomVeiw3(Context context) {
        super(context);
    }

    public CustomVeiw3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        recording();
    }

    public CustomVeiw3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;
    private Picture picture;

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5f);

        picture = new Picture();
    }

    private void recording() {
        Canvas canvas = picture.beginRecording(500, 500);

        // 在Canvas中具体操作
        // 坐标系位移
        canvas.translate(250, 250);
        // 绘制一个圆
        canvas.drawCircle(0, 0, 100, paint);
        canvas.drawCircle(80, 80, 50, paint);

        picture.endRecording();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        picture.draw(canvas);

        PictureDrawable pictureDrawable = new PictureDrawable(picture);
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        pictureDrawable.setBounds(0, 0, 500, picture.getHeight());
        pictureDrawable.draw(canvas);
    }
}
