package com.example.testdemo.animator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.testdemo.LLog
import kotlinx.android.synthetic.main.activity_animator.*
import java.lang.ref.Reference
import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference

class AnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)

        makeAnimator()

        btn_retry.setOnClickListener {
            makeAnimator()
        }

        iv_target.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
    }

    fun makeAnimator() {
        val animatorUtils = AnimatorUtils()

        animatorUtils.apply {
            makeAnimatorWithViewPropertyAnimator(iv_target)
        }

    }
}