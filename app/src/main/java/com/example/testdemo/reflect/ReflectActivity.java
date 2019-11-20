package com.example.testdemo.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;
import com.example.testdemo.LLog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect2);
        reflectMethod();
        reflectWitName();
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

    private void reflectWitName() {
        try {
            Class cl = Class.forName("com.example.testdemo.reflect.People");
            Constructor constructor = cl.getConstructor(String.class, int.class);
            Object people = constructor.newInstance("Jack", 28);
//            Method setAgeMethod = cl.getMethod("setAge", int.class);
//            setAgeMethod.invoke(people, 29);
            Method getAgeMethod = cl.getMethod("getAge");
            LLog.d("reflectWitName", getAgeMethod.invoke(people));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
