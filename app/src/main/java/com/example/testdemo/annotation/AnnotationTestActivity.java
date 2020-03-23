package com.example.testdemo.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;

@Person(age = 28, name = "xiaoming")
public class AnnotationTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation_test);

        boolean isHadAnnotation = AnnotationTestActivity.class.isAnnotationPresent(Person.class);
        if (isHadAnnotation) {
            Person person = AnnotationTestActivity.class.getAnnotation(Person.class);
            System.out.println("age:" + person.age());
            System.out.println("name:" + person.name());
        }
    }
}
