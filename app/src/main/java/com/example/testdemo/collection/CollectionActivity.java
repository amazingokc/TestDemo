package com.example.testdemo.collection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator it1 = list.listIterator();
        ListIterator it2 = list.listIterator();
        it1.next();
        it1.remove();
//        it2.next(); //抛出异常java.util.ConcurrentModificationException
    }
}
