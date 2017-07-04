package com.example.lenovo.yinyuebofangqi.inject.component;

import com.example.lenovo.yinyuebofangqi.inject.module.SplashModule;
import com.example.lenovo.yinyuebofangqi.ui.activity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lenovo on 2017/7/2.
 */
@Singleton
@Component(modules = SplashModule.class)
public interface SplashComponent {
    void inject(SplashActivity activity);

}
