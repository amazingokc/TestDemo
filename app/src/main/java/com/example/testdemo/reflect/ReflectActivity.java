package com.example.testdemo.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;
import com.example.testdemo.LLog;

import java.lang.reflect.Method;

public class ReflectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect2);
        reflectMethod();
    }

    private void reflectMethod() {

        People people = new People();
        Class cl = people.getClass();
        try {
            Method setNameMethod = cl.getDeclaredMethod("setName", String.class);
            Method getNameMethod = cl.getDeclaredMethod("getName");
            setNameMethod.setAccessible(true);
            getNameMethod.setAccessible(true);
            setNameMethod.invoke(people, "jack");
            LLog.d("reflectMethodaa", getNameMethod.invoke(people));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
