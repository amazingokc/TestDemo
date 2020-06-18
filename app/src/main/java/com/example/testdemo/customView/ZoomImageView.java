package com.example.testdemo.customView;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.testdemo.LLog;

public class ZoomImageView extends androidx.appcompat.widget.AppCompatImageView implements
        ViewTreeObserver.OnGlobalLayoutListener, ScaleGestureDetector.OnScaleGestureListener,
        View.OnTouchListener {
    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        matrix = new Matrix();
        setOnTouchListener(this);
        scaleGestureDetector = new ScaleGestureDetector(context, this);

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (gestureRunnable == null) {
                    gestureRunnable = new GestureRunnable();
                }
                if (!isZooming) {
                    targetScale = 0;
                    if (getCurrentScale() < initScale) {
                        targetScale = initScale;
                        toScale = MAX_TO_SCALE;
                    } else if (getCurrentScale() >= initScale && getCurrentScale() < midScale) {
                        targetScale = midScale;
                        toScale = MAX_TO_SCALE;
                    } else if (getCurrentScale() == midScale) {
                        targetScale = initScale;
                        toScale = MIN_TO_SCALE;
                    } else if (getCurrentScale() > midScale) {
                        targetScale = midScale;
                        toScale = MIN_TO_SCALE;
                    }
                    gestureRunnable.run();
                }
                return true;
            }
        });

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

    private GestureRunnable gestureRunnable;
    private static final float MAX_TO_SCALE = 1.08f;
    private static final float MIN_TO_SCALE = 0.92f;
    private float toScale;
    private boolean isZooming;
    private float targetScale = 0;


    private class GestureRunnable implements Runnable {

        @Override
        public void run() {
            toScale(toScale, targetScale);

            float currentScale = getCurrentScale();
            if (currentScale != targetScale) {
                postDelayed(gestureRunnable, 5);
                isZooming = true;
            } else {
                isZooming = false;
            }
        }
    }

    //双击缩放
    private void toScale(float scale, float targetScale) {
        float toScale = scale;
        if (Math.abs(getCurrentScale() - targetScale) < 0.05) {
            toScale = targetScale / getCurrentScale();
        }
        matrix.postScale(toScale, toScale, width / 2, height / 2);
        setImageMatrix(matrix);

        setBorderAndCenterWhenScale();
    }

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
        if (scaleFactor < 1.0f && getCurrentScale() < minScale) {
            scaleFactor = 1.0f;
        }
        if (scaleFactor > 1.0f && getCurrentScale() > maxScale) {
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

    //边界及居中处理
    private void setBorderAndCenterWhenScale() {

        rectF = getMatrixRectF();
        float left = rectF.left;
        float right = rectF.right;
        float top = rectF.top;
        float bottom = rectF.bottom;

        float rectFWidth = rectF.width();
        float rectFHeighth = rectF.height();
        float dx = 0;
        float dy = 0;
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

    private float lastX;
    private float lastY;
    private int lastPointCount;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        scaleGestureDetector.onTouchEvent(event);

        int pointCount = event.getPointerCount();

        float currentX = 0;
        float currentY = 0;
        for (int i = 0; i < pointCount; i++) {
            currentX += event.getX(i);
            currentY += event.getY(i);
        }
        currentX /= pointCount;
        currentY /= pointCount;

        if (pointCount != lastPointCount) {
            lastPointCount = pointCount;
            lastX = 0;
            lastY = 0;
        }


        LLog.d("adsadewewqewq", event.getPointerCount()
                + "\n" + "currentX:" + currentX
                + "\n" + "currentY:" + currentY);

        RectF rectF = getMatrixRectF();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if ((rectF.width() > width + 0.01 || rectF.height() > height + 0.01)) {
                    if (getParent() instanceof ViewPager) {
                        //禁止父类拦截事件
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
//                if ((rectF.width() > width + 0.01 || rectF.height() > height + 0.01)) {
//                    if (getParent() instanceof ViewPager) {
//                        //禁止父类拦截事件
//                        getParent().requestDisallowInterceptTouchEvent(true);
//                    }
//                }
                if (lastX != 0) {
                    float dx = currentX - lastX;
                    float dy = currentY - lastY;
                    matrix.postTranslate(dx, dy);
                    setImageMatrix(matrix);
                    setBorderAndCenterWhenScale();
                }

                lastX = currentX;
                lastY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                lastPointCount = 0;
                lastX = 0;
                lastY = 0;
                break;
            case MotionEvent.ACTION_CANCEL:
                LLog.d("MotionEvent.ACTION_CANCEL","MotionEvent.ACTION_CANCEL");
                break;
            default:
        }

        return true;
    }

}
