package com.example.lenovo.yinyuebofangqi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.yinyuebofangqi.R;
import com.example.lenovo.yinyuebofangqi.inject.component.DaggerSplashComponent;
import com.example.lenovo.yinyuebofangqi.inject.module.SplashModule;
import com.example.lenovo.yinyuebofangqi.presenter.contract.SplashContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/2.
 */
public class SplashActivity extends BaseActivity implements SplashContract.View {

    @BindView(R.id.splash_img)
    ImageView splashImg;
    @BindView(R.id.splash_txt)
    TextView splashTxt;

    //presenter层对象  接口类型
    @Inject
    SplashContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        DaggerSplashComponent
                .builder()
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
        presenter.timingBegin();
    }

    @OnClick({R.id.splash_img, R.id.splash_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.splash_img:
                break;
            case R.id.splash_txt:
                presenter.startIntent();
                break;
        }
    }
//跳转方法
    @Override
    public void intent2Act() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
