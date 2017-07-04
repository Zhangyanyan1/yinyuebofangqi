package com.example.lenovo.yinyuebofangqi.inject.module;

import com.example.lenovo.yinyuebofangqi.presenter.contract.SplashContract;
import com.example.lenovo.yinyuebofangqi.presenter.impl.SplashPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/7/2.
 */
@Module
public class SplashModule {
    SplashContract.Presenter splashPresenter;

    public SplashModule(SplashContract.View activity) {
        this.splashPresenter = new SplashPresenter(activity);
    }

    @Provides
    @Singleton
    SplashContract.Presenter providesMainPresenter() {
        return splashPresenter;
    }
}
