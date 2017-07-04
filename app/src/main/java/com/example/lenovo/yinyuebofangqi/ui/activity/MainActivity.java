package com.example.lenovo.yinyuebofangqi.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lenovo.yinyuebofangqi.R;
import com.example.lenovo.yinyuebofangqi.inject.component.DaggerMainComponent;
import com.example.lenovo.yinyuebofangqi.inject.module.MainModule;
import com.example.lenovo.yinyuebofangqi.ui.fragment.BaseFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainLiveFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainMusicFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainVideoFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tablayout)
    TabLayout mainTablayout;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;

    private ArrayList<BaseFragment> fragments = new ArrayList<>();
    @Inject
    MainMusicFragment musicFragment;
    @Inject
    MainVideoFragment videoFragment;
    @Inject
    MainLiveFragment liveFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //判断设备版本是否大于4.4  api19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        setContentView(R.layout.activity_main);
        //绑定当前页面根布局
        ButterKnife.bind(this);

        DaggerMainComponent
                .builder()
                .mainModule(new MainModule())
                .build()
                .inject(this);

        //添加fragment到集合中
        addFragment();

        // 设置viewpager
        setViewpager();
    }

    // 设置状态栏透明状态
    private void   setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void setViewpager() {
        // 初始化 适配器
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //设置pager标题
            @Override
            public CharSequence getPageTitle(int position) {
                // 获取 string.xml中的 StringArray的值
                return getResources().getStringArray(R.array.fragment_list)[position];
            }
        };
        // 给viewpager设置适配器
        mainViewpager.setAdapter(fragmentPagerAdapter);
        // 设置 tablayout和viewpager联动
        mainTablayout.setupWithViewPager(mainViewpager);
    }

    private void addFragment() {
        fragments.add(musicFragment);
        fragments.add(videoFragment);
        fragments.add(liveFragment);
    }

    @OnClick({R.id.main_tablayout, R.id.main_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_tablayout:
                break;
            case R.id.main_viewpager:
                break;
        }
    }
}
