package com.example.testdemo.proxy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;

import java.lang.reflect.Proxy;

public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        //静态
//        CarProxyMerchant carProxyMerchant = new CarProxyMerchant();
//        carProxyMerchant.sell();

        //动态
        CarProducer carProducer = new CarProducer();
        PlatformMerchant platformMerchant = new PlatformMerchant(carProducer);
        Isell dynamicProxy = (Isell) Proxy.newProxyInstance(CarProducer.class.getClassLoader(),
                CarProducer.class.getInterfaces(),
                platformMerchant);
        dynamicProxy.sell();

    }

}
