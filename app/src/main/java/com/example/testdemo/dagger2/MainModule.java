package com.example.testdemo.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-15 下午 4:21
 * 文件描述：
 */
@Module
public class MainModule {

    private final MainView mainView;

    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    MainView provideMianView() {
        return mainView;
    }
}
