package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomVeiw6 extends View {
    public CustomVeiw6(Context context) {
        super(context);
    }

    public CustomVeiw6(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomVeiw6(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint;
    private Path path;

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        paint.setTextSize(40);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(250, 250);

//        path.lineTo(100, 100);
//        path.lineTo(100,0);
//        path.close();
//        canvas.drawPath(path, paint);

//        path.lineTo(100, 100);
//        path.moveTo(100, 50);
//        path.lineTo(100, 0);
//        canvas.drawPath(path, paint);

//        path.lineTo(100, 100);
//        path.setLastPoint(100, 50);
//        path.lineTo(100, 0);
//        path.close();
//        canvas.drawPath(path, paint);

//        RectF rect = new RectF(0, 0, 200, 200);
//        path.addRect(rect, Path.Direction.CW);
//        path.setLastPoint(-50, 250);
//        canvas.drawPath(path, paint);

//        RectF rect = new RectF(0, 0, 200, 200);
//        path.addRect(rect, Path.Direction.CCW);
//        path.setLastPoint(250, -50);
//        canvas.drawPath(path, paint);

//        RectF rect = new RectF(0, 0, 200, 200);
//        path.addRect(rect, Path.Direction.CW);
//        path.addCircle(100, 0, 50, Path.Direction.CW);
//        canvas.drawPath(path, paint);

//        path.lineTo(40, -40);
//        RectF rectF = new RectF(0, -80, 80, 0);
//        path.addArc(rectF, 90, 240); //直接添加一个圆弧到path中
//        canvas.drawPath(path, paint);

//        path.lineTo(40, -30);
//        RectF rectF = new RectF(0, -80, 80, 0);
//        //添加一个圆弧到path
//        //true	将最后一个点移动到圆弧起点，即不连接最后一个点与圆弧起点(因为两个点已经重叠了)
//        //false	不移动，而是连接最后一个点与圆弧起点
//        path.arcTo(rectF, 0, 240,true);
//        canvas.drawPath(path, paint);

//        Path path = new Path();                     // path添加一个矩形
//        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
//        Path src = new Path();                      // src添加一个圆
//        src.addCircle(0, 0, 100, Path.Direction.CW);
//        path.set(src);                              // 大致相当于 path = src;
//        canvas.drawPath(path, paint);

//        Path path = new Path();                     // path中添加一个圆形(圆心在坐标原点)
//        path.addCircle(0, 0, 100, Path.Direction.CW);
//        canvas.drawPath(path, paint);               // 绘制path
//        // 平移
//        path.offset(300, 0, path);
//        paint.setColor(Color.BLUE);                // 更改画笔颜色
//        canvas.drawPath(path, paint);              // 绘制path
    }


}
