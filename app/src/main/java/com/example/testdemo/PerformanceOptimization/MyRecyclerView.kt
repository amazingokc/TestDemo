package com.example.testdemo.PerformanceOptimization

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {



    override fun requestLayout() {
        super.requestLayout()
    }
}