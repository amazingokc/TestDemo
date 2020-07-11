package com.example.testdemo.retrofit;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Create by: xiaoguoqing
 * Date: 2018/12/24 0024
 * description:
 */
public class GsonUtil {

    private static final Gson GSON;

    static {
        GSON = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()//打开Export注解，但打开了这个注解,副作用，要转换和不转换都要加注解
//              .serializeNulls()  //是否序列化空值
                .setDateFormat("yyyy-MM-dd HH:mm:ss")//序列化日期格式  "yyyy-MM-dd"
//              .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写
                .setPrettyPrinting() //自动格式化换行
//              .setVersion(1.0)  //需要结合注解使用，有的字段在1。0的版本的时候解析，但0。1版本不解析
                .create();
    }

    //获取gson解析器
    public static Gson getGson() {
        return GSON;
    }

    //对象转换为json
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    //JSON转换为对象1--普通类型
    public static <T> T fromJson(String json, Class<T> classOfT) {
        if (TextUtils.isEmpty(json) || classOfT == null) return null;
        return GSON.fromJson(json, classOfT);
    }

    /**
     * 将json转化为对象，_开头的会被忽略
     */
    public static  BaseResponse2 fromJson(String jsonString, Type type) {
        if (TextUtils.isEmpty(jsonString) || type == null) {
            return null;
        }
        BaseResponse2 tmp = null;
        try {
            tmp = GSON.fromJson(jsonString, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
