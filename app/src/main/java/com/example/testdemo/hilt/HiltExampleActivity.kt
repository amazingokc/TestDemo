package com.example.testdemo.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.R
//import dagger.hilt.android.AndroidEntryPoint

//提供依赖项
//@AndroidEntryPoint
class HiltExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_example)
    }
}