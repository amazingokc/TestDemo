package com.example.testdemo;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;
import com.example.testdemo.aidl.AIDLActivity;
import com.example.testdemo.aidl.AIDLService;
import com.example.testdemo.custom_view.CustomViewActivity;
import com.example.testdemo.fragment_test.Main3Activity;
import com.example.testdemo.kotlin.CoroutinesActivity;
import com.example.testdemo.kotlin.KotlinActivity;
import com.example.testdemo.kotlin.Main2Activity;
import com.example.testdemo.proxy.ProxyActivity;
import com.example.testdemo.reflect.ReflectActivity;
import com.example.testdemo.viewDispatchEvent.DispatchEventActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        findViewById(R.id.btn_proxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, ProxyActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_view_dispatch_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(LauncherActivity.this, DispatchEventActivity.class);
//                startActivity(intent);

//                Intent intent = new Intent(LauncherActivity.this, CoroutinesActivity.class);
//                startActivity(intent);
            }
        });

        Intent intent = new Intent(LauncherActivity.this, Main3Activity.class);
        startActivity(intent);
        finish();


    }


}
