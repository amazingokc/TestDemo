package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;

import static android.view.GestureDetector.*;

public class ZoomImageView extends android.support.v7.widget.AppCompatImageView implements
        ViewTreeObserver.OnGlobalLayoutListener, ScaleGestureDetector.OnScaleGestureListener,
        View.OnTouchListener {
    public ZoomImageView(Context context) {
        super(context);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        matrix = new Matrix();
        setOnTouchListener(this);
        scaleGestureDetector = new ScaleGestureDetector(context, this);

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (getCurrentScale() < initScale) {
                    toScale(initScale);
                } else if (getCurrentScale() >= initScale && getCurrentScale() < midScale) {
                    toScale(midScale);
                } else if (getCurrentScale() == midScale) {
                    toScale(initScale);
                } else if (getCurrentScale() > midScale) {
                    toScale(midScale);
                }
                return true;
            }
        });

    }


    private void toScale(float scale) {
        float toScale = scale / getCurrentScale();
        matrix.postScale(toScale, toScale, width / 2, height / 2);
        setImageMatrix(matrix);

        setBorderAndCenterWhenScale();
    }

    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    private boolean isInit;
    private Matrix matrix;

    //控件宽高
    private float width;
    private float height;

    //手势缩放最大与最小倍数
    private float maxScale;
    private float midScale;
    private float initScale;
    private float minScale;
    //手势缩放监听
    private ScaleGestureDetector scaleGestureDetector;
    private GestureDetector gestureDetector;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    public void onGlobalLayout() {
        if (!isInit) {
            isInit = true;
        } else {
            return;
        }
        Drawable drawable = getDrawable();
        if (drawable == null)
            return;
        float dw = drawable.getIntrinsicWidth();
        float dh = drawable.getIntrinsicHeight();

        float scale = 1.0f;

        if (width > dw && height < dh) {
            scale = height * 1.0f / dh;
        }

        if (width < dw && height > dh) {
            scale = width * 1.0f / dw;
        }

        if ((width > dw && height > dh) || (width < dw && height < dh)) {
            scale = Math.min(width * 1.0f / dw, height * 1.0f / dh);
        }

        float disX = 0;
        float disY = 0;

        //缩放
        matrix.postScale(scale, scale, dw / 2, dh / 2);
        //计算X轴移动距离
        if (width < dw) {
            disX = (Math.min(width, dw) / 2) - (Math.max(width, dw) / 2);
        } else if (width > dw) {
            disX = (Math.max(width, dw) / 2) - (Math.min(width, dw) / 2);
        }
        //计算Y轴移动距离
        if (height < dh) {
            disY = (Math.max(height, dh) / 2) - (Math.min(height, dh) / 2);
        } else if (height > dh) {
            disY = (Math.max(height, dh) / 2) - (Math.min(height, dh) / 2);
        }

        matrix.postTranslate(disX, disY);
        setImageMatrix(matrix);

        maxScale = 4 * scale;
        midScale = 2 * scale;
        initScale = scale;
        minScale = scale / 2;

    }

    private float getCurrentScale() {
        float[] values = new float[9];
        matrix.getValues(values);
        return values[Matrix.MSCALE_X];
    }


    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        if (scaleFactor < 1.0f && getCurrentScale() < minScale * 0.8) {
            scaleFactor = 1.0f;
        }
        if (scaleFactor > 1.0f && getCurrentScale() > maxScale * 1.4) {
            scaleFactor = 1.0f;
        }

        if (scaleFactor != 1.0f) {
            //已手指焦点为缩放中心点
            matrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());
            setImageMatrix(matrix);

            setBorderAndCenterWhenScale();
        }
        return true;
    }

    private RectF rectF;
    private float dx;
    private float dy;

    private RectF getMatrixRectF() {

        Matrix matrix = this.matrix;
        if (rectF == null) {
            rectF = new RectF();
        }

        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    private void setBorderAndCenterWhenScale() {

        rectF = getMatrixRectF();
        float left = rectF.left;
        float right = rectF.right;
        float top = rectF.top;
        float bottom = rectF.bottom;

        float rectFWidth = rectF.width();
        float rectFHeighth = rectF.height();
        dx = 0;
        dy = 0;
        /**
         * 居中
         * */
        if (rectFWidth <= width && left + (rectFWidth / 2) < width / 2) {
            dx = (width / 2) - left - rectFWidth / 2;//右移
        }
        if (rectFWidth <= width && right - (rectFWidth / 2) > width / 2) {
            dx = -(right - (rectFWidth / 2) - width / 2);//左移
        }
        //
        if (rectFHeighth <= height && top + (rectFHeighth / 2) < height / 2) {
            dy = (height / 2) - top - rectFHeighth / 2;//下移
        }
        if (rectFHeighth <= height && bottom - (rectFHeighth / 2) > height / 2) {
            dy = -(bottom - (rectFHeighth / 2) - height / 2);//左移
        }

        /**
         * 边界处理
         * */
        if (rectFWidth > width && left > 0) {
            dx = -left;
        }
        if (rectFWidth > width && right < width) {
            dx = width - right;
        }
        if (rectFHeighth > height && top > 0) {
            dy = -top;
        }
        if (rectFHeighth > height && bottom < height) {
            dy = height - bottom;
        }

        if (Math.abs(dx) > 0.01 || Math.abs(dy) > 0.01) {
            matrix.postTranslate(dx, dy);
            setImageMatrix(matrix);
        }
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        scaleGestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:
                float scale = getCurrentScale();
                //如果缩放倍数越界了，需要回到边界倍数
                if (scale > maxScale) {
                    matrix.postScale(maxScale / scale, maxScale / scale, width / 2, height / 2);
                    setImageMatrix(matrix);
                } else if (scale < minScale) {
                    matrix.postScale(minScale / scale, minScale / scale, width / 2, height / 2);
                    setImageMatrix(matrix);
                }
                break;
            default:
        }
        return true;
    }
}
