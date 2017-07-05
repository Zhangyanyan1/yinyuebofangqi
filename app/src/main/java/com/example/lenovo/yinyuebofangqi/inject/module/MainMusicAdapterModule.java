package com.example.lenovo.yinyuebofangqi.inject.module;

import android.content.Context;

import com.example.lenovo.yinyuebofangqi.presenter.contract.MusicMainContract;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/7/2.
 */
@Module
public class MainMusicAdapterModule {
    Context context;
    ArrayList<String> list;
    private MusicMainContract.View view;

    @Provides
    MusicMainContract.View getMusicMainPresenter() {
        return view;
    }



    public MainMusicAdapterModule(Context context, ArrayList<String> list, MusicMainContract.View view) {
        this.context = context;
        this.list = list;
        this.view = view;
    }

    @Provides
    Context providesContext() {
        return context;
    }

    @Provides
    ArrayList<String> providesArrayList() {
        return list;
    }

}
