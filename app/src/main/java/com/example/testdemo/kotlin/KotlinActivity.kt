package com.example.testdemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.test.R
import android.widget.Toast.makeText as makeText1

class KotlinActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        var str: String = getString()
        Log.d("TTTT", "" + getString().length)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            Log.d("button", "button")
            makeText1(this, "click", Toast.LENGTH_LONG).show()
        }

        val people = listOf(Person("jack", 29),
                Person("nick", 23),
                Person("jone", 26))

        println(people.maxBy { it.age })
        println(people.maxBy({person: Person -> person.age }))

//        "abc"*10

        button.run {
            textSize = 13.0F
            setOnClickListener { View.OnClickListener {
                makeText1(this@KotlinActivity, "", Toast.LENGTH_LONG).show()
            } }
        }

        println(sum(1, 2))
    }

    val sum: (Int, Int) -> Int = { x, y -> x + y }


    fun getString(): String {
        return "HH"
    }

    data class Person(val name: String, val age: Int)

    operator fun String.times(int :Int) {
//        var sb = StringBuilder()
//        sb.append(this)
    }
}
