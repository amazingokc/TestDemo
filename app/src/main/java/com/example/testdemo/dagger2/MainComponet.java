package com.example.testdemo.dagger2;

import dagger.Component;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-15 下午 4:24
 * 文件描述：
 */
@Component(modules = MainModule.class)
public interface MainComponet {
    void inject(MainActivity mainActivity);
}
