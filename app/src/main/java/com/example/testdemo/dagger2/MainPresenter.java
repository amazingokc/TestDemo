package com.example.testdemo.dagger2;

import javax.inject.Inject;

/**
 * 作者：xiaoguoqing
 * 创建时间：2019-08-15 下午 3:30
 * 文件描述：
 */
public class MainPresenter {

    private MainView mainView;

    @Inject
    MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }
}
