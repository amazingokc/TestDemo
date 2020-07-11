package com.example.testdemo.retrofit

import android.os.Parcel
import android.os.Parcelable

data class MyBean(var data: Data) {


    class Data(){
        var curPage : Int = 0



        override fun toString(): String {
            return "Data(curPage=$curPage)"
        }


    }

    override fun toString(): String {
        return "BaseResponse(data=$data)"
    }


}
