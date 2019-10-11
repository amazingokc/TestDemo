package com.example.testdemo.reflect;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-10-11 上午 9:14
 * 文件描述：
 */
public class People {

    private String name;

    public int age;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
