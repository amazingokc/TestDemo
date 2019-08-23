package com.example.testdemo.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.test.R;

import javax.inject.Inject;



public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponet.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

    }
}
