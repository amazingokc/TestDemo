package com.example.testdemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test.R
import com.example.testdemo.LLog
import kotlinx.coroutines.*
import java.math.BigDecimal
import java.util.logging.Logger
import kotlin.math.log
import kotlin.math.log2

open class CoroutinesActivity : AppCompatActivity() {

    val TAG = "CoroutinesActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

//        GlobalScope.launch {
//
//        }
//        GlobalScope.launch(Dispatchers.Main){
//        LLog.d(TAG, "1")
//           val job = GlobalScope.launch(Dispatchers.IO.plus(CoroutineName("amazingokc"))) {
//                LLog.d(TAG, "2")
//                var str = "4"
////            withContext(Dispatchers.IO) {
////                LLog.d(TAG, "3")
////                str = "5"
////            }
////                delay(1000)
//                LLog.d(TAG, str)
//            }
////            LLog.d(TAG, "6")
////            job.join()
////            LLog.d(TAG, "7")
////        }
//
        var activity: AppCompatActivity = CoroutinesActivity()
//        if (activity is KotlinActivity) {
//            activity.aaaa()
//        }

//        (activity as? CoroutinesActivity).aaaa()
//        (activity as KotlinActivity)?.aaaa()
        (activity as? KotlinActivity)?.aaaa()
    }

    suspend fun main() {

    }

    open fun aaaa() {
        print("555")
    }

//    fun aVoid(list: List<Double>) {
//        println(list)
//    }
//
//    fun aVoid(list: List<Int>) {
//        println(list)
//    }
//
//    fun <T> a() {
//        println(T::class.simpleName)
//    }

}
