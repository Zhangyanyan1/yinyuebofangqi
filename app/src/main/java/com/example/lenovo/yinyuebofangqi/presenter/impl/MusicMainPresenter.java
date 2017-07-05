package com.example.lenovo.yinyuebofangqi.presenter.impl;

import com.example.lenovo.yinyuebofangqi.presenter.contract.MusicMainContract;

import javax.inject.Inject;

/**
 * Created by lenovo on 2017/7/5.
 */

public class MusicMainPresenter implements MusicMainContract.Presenter {
    protected MusicMainContract.View view;

    @Inject
    public MusicMainPresenter(MusicMainContract.View view) {
        this.view = view;
    }

    @Override
    public void cardEnvnt(int id) {
        view.card2new(id);
    }

    @Override
    public void songLsitEnvnt() {
        view.song2new();
    }
}
