package com.example.testdemo.kotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.liveData
import com.example.test.R
import com.example.testdemo.LLog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import androidx.core.content.edit as edit1

class KTXActivity : AppCompatActivity() {

    val tag = "Main2Activity"

//    lateinit var tv: TextView

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        tv = findViewById(R.id.tv)
//        setView(tv)

//        val a = tv?.let {
//            it.textSize = 14.0f
//            it.text = "文本"
//            it.text
//        }
//        LLog.d("onCreate11", a)
//
//        val b = tv.let { tv ->
//            tv.text = "111"
//
//        }
//
//        val c = tv.run {
//            text = "111"
//        }
//
//        LLog.d("oncreateeee", b)

        /*** _______________________________________________________________
         * KTX的使用
         * * */
        sharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE)
        sharedPreferences.edit1(commit = true) {
            putBoolean("key", true)
            LLog.d(tag, sharedPreferences.getBoolean("key", false))
        }

        //Collection 扩展程序利用 Kotlin 的运算符重载简化集合串联等操作
        val combinedArratSet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        val newArraySet = combinedArratSet + 7 + 8
        LLog.d(tag, newArraySet)

        //借助 Fragment KTX 模块，可以使用 lambda 来简化 Fragment 事务
        supportFragmentManager.commit(allowStateLoss = true) {
            addToBackStack("...")
            setCustomAnimations(
                    R.anim.fragment_fade_enter,
                    R.anim.fragment_fade_exit)
            add(Fragment(), "...")
        }

        //使用 viewModels 和 activityViewModels 属性委托在一行中绑定到 ViewModel：
        // Get a reference to the ViewModel scoped to this Fragment
        //获取一个指向MyViewModel的引用到这里
        val viewModel by viewModels<MyViewModel>()
        LLog.d(tag, viewModel)
        //viewModels获取到的viewModel会缓存起来，再次获取拿到的是缓存
        val viewModel2 by viewModels<MyViewModel>()
        LLog.d(tag, viewModel2)

//        val intent = Intent(this, KTX2Activity::class.java)
//        startActivity(intent)
        // Get a reference to the ViewModel scoped to its Activity
        //activityViewModels 函数找不到，估计在另一个库
//        val viewModel2 by activityViewModels<MyViewModel>()

        lifecycleScope.launch {

        }
        lifecycleScope.launch {

        }


//        val user: LiveData<String> = liveData(this) {
//            val data = database.loadUser() // loadUser is a suspend function.
//            emit(data)
//        }

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()

    }

//    fun setView(tv: TextView?) {
//        LLog.d("asdsdada", tv?.id)
//        println()
////        print()
//    }
}
