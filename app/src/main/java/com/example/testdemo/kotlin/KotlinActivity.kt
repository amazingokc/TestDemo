package com.example.testdemo.kotlin

import android.os.Bundle
import android.widget.Button
import com.example.test.R
import com.example.testdemo.LLog
import java.math.BigDecimal


class KotlinActivity : CoroutinesActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

//        var str: String = getString()
//        Log.d("TTTT", "" + getString().length)
//        button = findViewById(R.id.button)
//        button.setOnClickListener {
//            Log.d("button", "button")
//            makeText1(this, "click", Toast.LENGTH_LONG).show()
//        }
//
        val people = listOf(
                Person("nick", 23),
                Person("jack", 29),
                Person("jone", 26))
//
        println(people.maxBy { it.age })
//        println(people.maxBy({person: Person -> person.age }))
//
////        "abc"*10
//
//        button.run {
//            textSize = 13.0F
//            setOnClickListener { View.OnClickListener {
//                makeText1(this@KotlinActivity, "", Toast.LENGTH_LONG).show()
//            } }
//        }
//
//        println(sum(1, 2))

//
//        val createInstances = CreateInstances.Second.getInstance()
//
//        var array = Array(100, init = { i -> i + 1 })
//        var intArray = arrayOf(1,2)
//        var list = listOf(1,2)
//
//
//        var mu:MutableList<Number> = mutableListOf(1,2,3)
//        mu.add(BigDecimal("11"))
//
//        LLog.d(mu)
    }

    val sum: (Int, Int) -> Int = { x, y -> x + y }


    fun getString(): String {
        return "HH"
    }

    data class Person(val name: String, val age: Int)

    operator fun String.times(int: Int) {
//        var sb = StringBuilder()
//        sb.append(this)
    }

    override fun aaaa() {
        super.aaaa()
    }

}
