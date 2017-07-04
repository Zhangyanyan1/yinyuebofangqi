package com.example.lenovo.yinyuebofangqi.inject.component;

import com.example.lenovo.yinyuebofangqi.inject.module.MainMusicAdapterModule;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainMusicFragment;

import dagger.Component;

/**
 * Created by lenovo on 2017/7/2.
 */

@Component(modules = MainMusicAdapterModule.class)
public interface MainMusicAdapterComponent {
    void inject(MainMusicFragment activity);
}
