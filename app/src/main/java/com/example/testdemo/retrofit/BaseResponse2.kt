package com.example.testdemo.retrofit

data class BaseResponse2<T>(var data: T) {

    override fun toString(): String {
        return "BaseResponse2(data=$data)"
    }
}