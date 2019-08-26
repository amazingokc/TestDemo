package com.example.testdemo.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-23 下午 2:36
 * 文件描述：平台商家
 */
public class PlatformMerchant implements InvocationHandler {

    private Object pingtai;

    public PlatformMerchant(Object pingtai) {
        this.pingtai = pingtai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d("sell", "动态代理");
        method.invoke(pingtai,args);
        return null;
    }
}
