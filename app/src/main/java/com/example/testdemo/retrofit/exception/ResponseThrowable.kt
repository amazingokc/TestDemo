package com.example.testdemo.retrofit.exception

class ResponseThrowable(override var message: String?, var code: Int) : Exception() {

}