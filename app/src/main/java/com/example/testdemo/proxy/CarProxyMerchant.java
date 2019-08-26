package com.example.testdemo.proxy;

import android.util.Log;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-23 下午 1:48
 * 文件描述：轿车代理商
 */
public class CarProxyMerchant implements Isell {

    private CarProducer carProducer;

    public CarProxyMerchant() {
        this.carProducer = new CarProducer();
    }

    @Override
    public void sell() {
        Log.d("sell", "静态代理");
        carProducer.sell();
    }
}
