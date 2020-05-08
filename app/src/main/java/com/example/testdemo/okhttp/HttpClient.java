package com.example.testdemo.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient {

    static class InnerClass {
        static final OkHttpClient OkHttpClientHolder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    private OkHttpClient httpClientHolder() {
        return InnerClass.OkHttpClientHolder;
    }

    private void getRequest() {
        Request request = new Request.Builder().get().build();


        httpClientHolder()
                .newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                    }
                });
    }

}
