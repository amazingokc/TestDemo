package com.example.testdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.example.testdemo.proxy.ProxyActivity;

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
    }
}
