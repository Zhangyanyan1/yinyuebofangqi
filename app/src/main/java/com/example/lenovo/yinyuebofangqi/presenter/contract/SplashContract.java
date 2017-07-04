package com.example.lenovo.yinyuebofangqi.presenter.contract;

/**
 *启动页面相关内容
 * Created by lenovo on 2017/6/28.
 */

public interface SplashContract {
    /**
     *View接口
     */
   interface View{
       void intent2Act();
   }

    /**
     *Presenter接口
     */
    interface Presenter {
        void timingBegin();

        void startIntent();
    }
}
