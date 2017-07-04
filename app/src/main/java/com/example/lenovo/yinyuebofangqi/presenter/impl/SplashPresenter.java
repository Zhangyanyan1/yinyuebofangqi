package com.example.lenovo.yinyuebofangqi.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.example.lenovo.yinyuebofangqi.presenter.contract.SplashContract;

/**
 * Created by lenovo on 2017/6/28.
 */

public class SplashPresenter implements SplashContract.Presenter{
    private static final int DELAYED_TIME = 3000;
    private static final int MESSAGE_WHAT = 103;

    private SplashContract.View view;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            view.intent2Act();
        }
    };

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void timingBegin() {
        handler.sendEmptyMessageDelayed(MESSAGE_WHAT, DELAYED_TIME);
    }

    @Override
    public void startIntent() {
        handler.removeMessages(MESSAGE_WHAT);
        view.intent2Act();
    }

}
