package com.example.testdemo.animator

import android.animation.*
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.*
import com.example.testdemo.LLog

class AnimatorUtils {

    fun makeAnimatorWithValueAnimator(objectView: View) {
        ValueAnimator.ofFloat(800.0f).apply {
            duration = 3000
            addUpdateListener {
                objectView.translationX = it.animatedValue as Float
            }
//            interpolator = LinearInterpolator()
//            interpolator = OvershootInterpolator()
//            interpolator = AnticipateInterpolator()
            interpolator = AnticipateOvershootInterpolator()
            start()
        }
    }

    fun makeAnimatorWithObjectAnimator(objectView: View) {
        ObjectAnimator.ofFloat(objectView, "translationX", 0f, 800.0f).apply {
            duration = 4000

            //可随意监听想监听的行为
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    super.onAnimationStart(animation)
                }

                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                }
            })

            start()
        }
    }


    fun makeAnimatorWithAnimatorSet(objectView: View) {
        val time: Long = 3000

        val translationX: Animator = ObjectAnimator.ofFloat(objectView, "translationX", 800.0f)
                .apply {
                    duration = time
                }

        val rotation = ObjectAnimator.ofFloat(objectView, "rotation", 270.0f)
                .apply {
                    duration = time
                }
        val scaleX: Animator = ObjectAnimator.ofFloat(objectView, "scaleX", 1.2f)
                .apply {
                    duration = time
                }
        val scaleY: Animator = ObjectAnimator.ofFloat(objectView, "scaleY", 1.2f)
                .apply {
                    duration = time
                }


        val translationY = ObjectAnimator.ofFloat(objectView, "translationY", 500.0f)
                .apply {
                    duration = time
                }

        val boucer = AnimatorSet().apply {
            play(translationX).with(rotation)
            play(scaleX).with(scaleY).after(translationX)
            start()
        }

        AnimatorSet().apply {
            play(boucer).before(translationY)
            start()
        }


    }

    fun makeAnimatorWithViewPropertyAnimator(objectView: View) {
        objectView.animate().translationX(700.0f).translationY(-700.0f).apply {
            duration = 3000

            start()
        }

    }
}