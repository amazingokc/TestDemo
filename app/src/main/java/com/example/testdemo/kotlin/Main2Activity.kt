package com.example.testdemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.test.R
import com.example.testdemo.LLog
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    //    lateinit var tv: TextView
    var mState: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        tv = findViewById(R.id.tv)
        setView(tv)

//        val a = tv?.let {
//            it.textSize = 14.0f
//            it.text = "文本"
//            it.text
//        }
//        LLog.d("onCreate11", a)

//        val b = tv.let ({ tv ->
//            tv.text = "111"
//        })
//
//        LLog.d("oncreateeee", b)

        mState = savedInstanceState?.getString("GAME_STATE_KEY")

        tv.setOnClickListener {
            tv?.let {
                it.textSize = 14.0f
                it.text = "文本"
                it.text
            }
            mState = "clicked"
        }

        LLog.d("onCreateaaa", mState)
    }

    fun setView(tv: TextView?) {
        LLog.d("asdsdada", tv?.id)
        println()
//        print()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        tv.text = savedInstanceState?.getString("TEXT_VIEW_KEY")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.run {
            putString("GAME_STATE_KEY", mState)
            putString("TEXT_VIEW_KEY", tv.text.toString())
        }
    }
}
