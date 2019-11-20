package com.example.testdemo.T;

import android.util.Log;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-10-26 上午 9:27
 * 文件描述：
 */
public class Genarator<T> {
    private T key;

    public void showkey(T genericObj) {
        printMsg(1,"2",2.0);
    }

    public <T> void get() {
    }

    public <T> void printMsg(T ... args){
        for(T t : args){
            Log.d("泛型测试","t is " + t);
        }
    }
}