package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomVeiw5 extends View {
    public CustomVeiw5(Context context) {
        super(context);
    }

    public CustomVeiw5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomVeiw5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5f);
        paint.setTextSize(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawText("123456", 100, 200, paint);


//        canvas.drawText("123456", 1, 3, 100, 200, paint);


        char[] chars = "123456".toCharArray();
        canvas.drawText(chars, 1, 3, 100, 200, paint);

//        canvas.drawPosText("123456", new float[]{
//                100, 200,
//                150, 250,
//                200, 300,
//                250, 350,
//                300, 400,
//                350, 450}, paint);

    }


}
