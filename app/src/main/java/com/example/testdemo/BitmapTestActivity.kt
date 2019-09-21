package com.example.testdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatImageView
import com.example.test.R

class BitmapTestActivity : AppCompatActivity() {

    lateinit var iv_bitmap:AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_test)
        iv_bitmap = findViewById(R.id.iv_bitmap)

    }
}
