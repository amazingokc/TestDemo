package com.example.testdemo.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.testdemo.LLog
import com.example.testdemo.retrofit.exception.ExceptionHandle
import com.example.testdemo.retrofit.exception.ResponseThrowable
import com.example.testdemo.retrofit.reflect.DataBean2
import com.example.testdemo.retrofit.reflect.TypeBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(ServiceApi::class.java)

        lifecycleScope.launch {
            try {
                val responseBody = withContext(Dispatchers.IO) {
                    LLog.d("result___", "loading")
                    service.getInfos()
                }
                val baseResponse2 = GsonUtil.fromJson(responseBody.toString(),
                        TypeBuilder.newInstance(BaseResponse2::class.java)
                                .addTypeParam(DataBean::class.java)
                                .build())
                val dataBean: DataBean2? = baseResponse2.data as? DataBean2

                LLog.d("result___success", dataBean?.curPage)
            } catch (e: Throwable) {
                val responseThrowable: ResponseThrowable = ExceptionHandle.handleException(e)
                LLog.d("result___failed", "errorCode:"+responseThrowable.code
                        + "\n" + "errorMessage:" + responseThrowable.message)

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()
    }
}