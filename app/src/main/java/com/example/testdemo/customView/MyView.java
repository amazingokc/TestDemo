package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.testdemo.LLog;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * MeasureSpec.EXACTLY //确定模式，父View希望子View的大小是确定的，由specSize决定；
     * MeasureSpec.AT_MOST //最多模式，父View希望子View的大小最多是specSize指定的值；
     * MeasureSpec.UNSPECIFIED //未指定模式，父View完全依据子View的设计值来决定；(比较少见，ScrollView嵌套一个Textview会出现这种模式)
     * <p>
     * 注意：
     * 如果对View的宽高进行修改了，不要调用 super.onMeasure( widthMeasureSpec, heightMeasureSpec);
     * 要调用 setMeasuredDimension( widthsize, heightsize); 这个函数。
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);      //取出宽度的确切数值
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);      //取出宽度的测量模式
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);    //取出高度的确切数值
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);    //取出高度的测量模式

        LLog.d("widthMeasureSpec:" + widthMeasureSpec + "\n"
                + "heightMeasureSpec:" + heightMeasureSpec + "\n"
                + "widthSize:" + widthSize + "\n"
                + "widthMode:" + widthMode + "\n"
                + "heightSize:" + heightSize + "\n"
                + "heightMode:" + heightMode + "\n"
                + "MeasureSpec.UNSPECIFIED:" + MeasureSpec.AT_MOST);

        widthMeasureSpec = widthMode + 200;
        heightMeasureSpec = heightMode + 200;
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 确定View大小
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LLog.d("onSizeChanged", "w:" + w + "\n"
                + "h:" + h + "\n"
                + "oldw:" + oldw + "\n"
                + "oldh:" + oldh + "\n");
    }

    /**
     * 1.确定子View布局位置
     * 2.四个参数代表相对父控件边界的距离
     * 3.该回调自定义View包含子View时有用
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制内容
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
