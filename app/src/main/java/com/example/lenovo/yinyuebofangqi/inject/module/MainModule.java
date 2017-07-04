package com.example.lenovo.yinyuebofangqi.inject.module;

import com.example.lenovo.yinyuebofangqi.ui.fragment.MainLiveFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainMusicFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainVideoFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/7/2.
 */
@Module
public class MainModule {
    @Provides
    @Singleton
    MainMusicFragment providesMainFragment() {
        return new MainMusicFragment();
    }
    @Provides
    @Singleton
    MainVideoFragment providesMainVideoFragment() {
        return new MainVideoFragment();
    }

    @Provides
    @Singleton
    MainLiveFragment providesMainLiveFragment() {
        return new MainLiveFragment();
    }
}
