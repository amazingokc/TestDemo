package com.example.testdemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

//        var str: String = getString()
        Log.d("TTTT", "" + getString()!!.length)

    }

    fun getString(): String? {
        return "HH"
    }
}
