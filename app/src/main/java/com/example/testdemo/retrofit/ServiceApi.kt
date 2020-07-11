package com.example.testdemo.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface ServiceApi {

    @GET("/article/list/1/json")
    suspend fun getInfos(): ResponseBody
}