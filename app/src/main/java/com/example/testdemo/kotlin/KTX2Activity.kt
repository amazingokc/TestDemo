package com.example.testdemo.kotlin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.testdemo.LLog

class KTX2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_k_t_x2)

        val viewModel by viewModels<MyViewModel>()
        LLog.d("Main2Activity", viewModel)
    }
}
