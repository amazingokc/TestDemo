package com.example.testdemo.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.example.test.R;
import com.example.testdemo.LLog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainView {

//    @Inject
//    MainPresenter mainPresenter;

    private Collection<String> possibleResultPoints = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerMainComponet.builder()
//                .mainModule(new MainModule(this))
//                .build()
//                .inject(this);


        Collection<String> currentPossible = possibleResultPoints;
        possibleResultPoints.add("11");
        possibleResultPoints.add("22");
        Collection<String> currentPossible2 = null;
        Collection<String> currentPossible3 = currentPossible2;
        currentPossible2 = possibleResultPoints;
        LLog.d("CollectionCollection","currentPossible:" + currentPossible);
        LLog.d("CollectionCollection","currentPossible2:" + currentPossible2);
        LLog.d("CollectionCollection","currentPossible3:" + currentPossible3);
//        currentPossible2.clear();
//        LLog.d("CollectionCollection","currentPossible:" + currentPossible);
//        LLog.d("CollectionCollection","currentPossible2:" + currentPossible2);

//        possibleResultPoints.add("33");
//        Iterator<String> iterator = currentPossible.iterator();
//        while(iterator.hasNext()){
//            String string = iterator.next();
//            if(string.equals("22"))
//                possibleResultPoints.remove(string);
//        }

//        final Collection<Integer> list = new HashSet();
//        list.add(3);
//        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer integer = iterator.next();
//            if(integer==2)
//                list.add(4);
//        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                list.add(4);
//                LLog.d("dsadasdasdasd",list.size());
//            }
//        }).start();
//
//        synchronized (list) {
//            for (Integer integer : list) {
//               LLog.d("dsadasdasdasd",integer);
//            }
//        }





    }
}
