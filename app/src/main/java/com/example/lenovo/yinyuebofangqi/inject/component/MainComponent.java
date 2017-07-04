package com.example.lenovo.yinyuebofangqi.inject.component;

import com.example.lenovo.yinyuebofangqi.inject.module.MainModule;
import com.example.lenovo.yinyuebofangqi.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lenovo on 2017/7/2.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
