package com.example.testdemo.kotlin

import android.support.v7.app.AppCompatActivity
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
    }

    fun setView(tv: TextView?) {
        LLog.d("asdsdada", tv?.id)
        println()
//        print()
    }
}
