package com.example.testdemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.test.R;
import com.example.testdemo.animator.AnimatorActivity;
import com.example.testdemo.customView.CustomViewActivity;
import com.example.testdemo.dagger2.MainActivity;
import com.example.testdemo.proxy.ProxyActivity;

import com.example.testdemo.PerformanceOptimization.recyclerview.RecyclerViewActivity;
import com.example.testdemo.retrofit.CoroutineActivity;
import com.example.testdemo.thread.HandlerThreadActivity;
import com.example.testdemo.tree.TreeActivity;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static java.lang.Thread.sleep;

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

        Intent intent = new Intent(this, TreeActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
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
