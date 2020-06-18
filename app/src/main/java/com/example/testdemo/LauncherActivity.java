package com.example.testdemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;
import com.example.testdemo.proxy.ProxyActivity;

import com.example.testdemo.PerformanceOptimization.RecyclerViewActivity;

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


        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("111", "222");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
