package com.example.testdemo.dragFloatView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.test.R;
import com.example.testdemo.LLog;
import com.example.testdemo.animator.AnimatorUtils;

/**
 * Author:xiaoguoqing
 * Time:2020/8/13   14:56
 * Des:
 */
public class DragFloatView extends RelativeLayout {

    private View rootView;
    private LinearLayout ll_drag_content_dragfloatview;//可拖动的控件
    private LinearLayout ll_open_view_dragfloatview;//隐藏的控件
    private TextView tv_name_dragfloatview;//内容信息
    private ImageView iv_icon_dragfloatview;//拖动触摸的控件
    private ImageView iv_close_dragfloatview;//关闭按钮

    private boolean isOpen; //是否处于打开状态（打开状态不可以拖动）

    private GestureDetector gestureDetector;
    private float openX;

    float lastX;
    float lastY;
    float dx;
    float dy;
    float endy;
    ObjectAnimator objectAnimators;


    public DragFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context);
    }

    public DragFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUI(final Context context) {
        rootView = LayoutInflater
                .from(context)
                .inflate(R.layout.layoutdragfloatview, this);

        ll_drag_content_dragfloatview = rootView.findViewById(R.id.ll_drag_content_dragfloatview);
        ll_open_view_dragfloatview = rootView.findViewById(R.id.ll_open_view_dragfloatview);
        tv_name_dragfloatview = rootView.findViewById(R.id.tv_name_dragfloatview);
        iv_icon_dragfloatview = rootView.findViewById(R.id.iv_icon_dragfloatview);
        iv_close_dragfloatview = rootView.findViewById(R.id.iv_close_dragfloatview);


        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
                if (isOpen) {
                    objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                            "translationX", 0f, openX);
                    objectAnimators.setDuration(200);
                    objectAnimators.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            isOpen = !isOpen;
                        }
                    });
                    objectAnimators.start();
                } else {
                    objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                            "translationX", openX, 0);
                    objectAnimators.setDuration(200);
                    objectAnimators.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            isOpen = !isOpen;
                        }
                    });
                    objectAnimators.start();
                }
                return true;
            }
        });


        ll_drag_content_dragfloatview.postDelayed(new Runnable() {
            @Override
            public void run() {
                openX = ll_open_view_dragfloatview.getWidth();

                objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                        "translationX", 0f, openX);
                objectAnimators.setDuration(1);
                objectAnimators.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ll_drag_content_dragfloatview.setVisibility(VISIBLE);
                    }
                });
                objectAnimators.start();


            }
        }, 200);

        iv_close_dragfloatview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clikListener != null) {
                    clikListener.clickClose();
                }
            }
        });

        iv_icon_dragfloatview.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (!isOpen) {
                            lastX = event.getRawX();
                            lastY = event.getRawY();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!isOpen) {
                            dx = event.getRawX() - lastX;
                            dy = event.getRawY() - lastY;

                            if (Math.abs(dx) > 10.0f || Math.abs(dy) > 10.0f) {
                                ll_open_view_dragfloatview.setVisibility(GONE);
                                ll_drag_content_dragfloatview.setTranslationX(dx);
                                ll_drag_content_dragfloatview.setTranslationY(dy + endy);
                            }
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        if (!isOpen) {
                            if (Math.abs(dx) > 10.0f) {
                                objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                                        "translationX", dx, 0);
                                objectAnimators.setDuration(200);
                                objectAnimators.start();
                            }

                            if (Math.abs(dy) > 10.0f) {
                                isNeedAdd = true;
                                endy = dy + endy;
                            }

                            LLog.d("onTouchonTouch", "当前Y坐标：" + ll_drag_content_dragfloatview.getY());

                        }

                        if (Math.abs(dx) < 10.f && Math.abs(dy) < 10.f) {
                            ll_open_view_dragfloatview.setVisibility(VISIBLE);
                            if (isOpen) {
                                objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                                        "translationX", 0f, openX);
                                objectAnimators.setDuration(200);
                                objectAnimators.addListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        isOpen = !isOpen;
                                    }
                                });
                                objectAnimators.start();
                            } else {
                                objectAnimators = ObjectAnimator.ofFloat(ll_drag_content_dragfloatview,
                                        "translationX", openX, 0);
                                objectAnimators.setDuration(200);
                                objectAnimators.addListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        isOpen = !isOpen;
                                    }
                                });
                                objectAnimators.start();
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    private boolean isNeedAdd;

    private ClikListener clikListener;

    public void setClikListener(ClikListener clikListener) {
        this.clikListener = clikListener;
    }

    public interface ClikListener {
        void clickClose();
    }

}
