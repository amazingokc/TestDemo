package com.example.testdemo.PerformanceOptimization.recyclerview

import RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var viewLayoutManager: LinearLayoutManager
    private lateinit var viewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        viewLayoutManager = LinearLayoutManager(this)
        viewAdapter = RecyclerViewAdapter()

        rv_content.apply {
            setHasFixedSize(true)
            layoutManager = viewLayoutManager
            adapter = viewAdapter;
        }
    }
}
