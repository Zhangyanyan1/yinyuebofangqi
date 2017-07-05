package com.example.lenovo.yinyuebofangqi.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.lenovo.yinyuebofangqi.R;
import com.example.lenovo.yinyuebofangqi.ui.fragment.BaseFragment;
import com.example.lenovo.yinyuebofangqi.ui.fragment.MainFragment;

public class MainActivity extends BaseActivity {
    private MainFragment mainFragment;


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
//        ButterKnife.bind(this);

        setFragment();
    }

    private void setFragment() {
        mainFragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_pager, mainFragment);
        transaction.commit();
    }

    public void intnet2local() {
        Toast.makeText(this, "aaaaaaaaaa", Toast.LENGTH_SHORT).show();
//        addFragment(new MainLiveFragment());
    }

    private void addFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_pager, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // 设置状态栏透明状态
    private void setTranslucentStatus(boolean on) {
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

}
