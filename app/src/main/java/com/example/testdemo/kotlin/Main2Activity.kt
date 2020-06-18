package com.example.testdemo.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.test.R
import com.example.testdemo.LLog
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

//    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        tv = findViewById(R.id.tv)
        setView(tv)

        val a = tv?.let {
            it.textSize = 14.0f
            it.text = "文本"
            it.text
        }
        LLog.d("onCreate11", a)

        val b = tv.let { tv ->
            tv.text = "111"

        }

        val c = tv.run {
            text = "111"
        }

        LLog.d("oncreateeee", b)
    }

    fun setView(tv: TextView?) {
        LLog.d("asdsdada", tv?.id)
        println()
//        print()
    }
}
