package com.example.lenovo.yinyuebofangqi.presenter.contract;

/**
 * Created by lenovo on 2017/7/5.
 */

public interface MusicMainContract {
    /**
     * View接口
     */
    interface View {
        void card2new(int id);

        void song2new();
    }

    /**
     * Presenter接口
     */
    interface Presenter {
        void cardEnvnt(int id);

        void songLsitEnvnt();
    }
}
