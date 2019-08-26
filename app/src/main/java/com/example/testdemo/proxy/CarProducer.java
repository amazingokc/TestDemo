package com.example.testdemo.proxy;

import android.util.Log;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-23 下午 1:46
 * 文件描述：轿车厂家
 */
public class CarProducer implements Isell {
    @Override
    public void sell() {
        Log.d("sell", "出售");
    }
}
