package com.example.lenovo.yinyuebofangqi.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.yinyuebofangqi.R;
import com.example.lenovo.yinyuebofangqi.inject.component.DaggerMainMusicAdapterComponent;
import com.example.lenovo.yinyuebofangqi.inject.module.MainMusicAdapterModule;
import com.example.lenovo.yinyuebofangqi.ui.adapter.SongListAdapter;
import com.example.lenovo.yinyuebofangqi.view.ScrollRecyclerLayoutManager;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/6/28.
 */

public class MainMusicFragment extends BaseFragment {
    @BindView(R.id.music_main_fragment_card_local)
    CardView cardLocal;
    @BindView(R.id.music_main_fragment_card_remote)
    CardView cardRemote;
    @BindView(R.id.music_main_fragment_card_download)
    CardView cardDownload;
    @BindView(R.id.music_main_fragment_card_lately)
    CardView cardLately;
    @BindView(R.id.music_main_fragment_card_like)
    CardView cardLike;
    @BindView(R.id.music_main_fragment_card_recommend)
    CardView cardRecommend;
    @BindView(R.id.fragment_music_main_list)
    RecyclerView recyclerView;
    Unbinder unbinder;

    @Inject
    SongListAdapter songListAdapter;
    ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_main, container, false);
        //绑定当前页面根布局
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = getList();

        DaggerMainMusicAdapterComponent
                .builder()
                .mainMusicAdapterModule(new MainMusicAdapterModule(getActivity(), list))
                .build()
                .inject(this);

        setListView();
    }

    private void setListView() {
        recyclerView.setAdapter(songListAdapter);
        recyclerView.setLayoutManager(new ScrollRecyclerLayoutManager(getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
    }

    @NonNull
    private ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("独家记忆");
        list.add("他来听我的演唱会");
        list.add("Baby,Don't Cry");
        list.add("Bab Girl");
        list.add("从此以后");
        list.add("多幸运");
        list.add("刚好遇见你");
        list.add("虹之间");
        list.add("龙卷风");
        list.add("原动力");
        list.add("不得不爱");
        list.add("不要说话");
        list.add("超级女孩");
        return list;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定当前页面根布局  fragment中需要调用此方法
        unbinder.unbind();
    }

    @OnClick({R.id.music_main_fragment_card_local, R.id.music_main_fragment_card_remote, R.id.music_main_fragment_card_download, R.id.music_main_fragment_card_lay, R.id.music_main_fragment_card_lately, R.id.music_main_fragment_card_like, R.id.music_main_fragment_card_recommend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.music_main_fragment_card_local:
                break;
            case R.id.music_main_fragment_card_remote:
                break;
            case R.id.music_main_fragment_card_download:
                break;
            case R.id.music_main_fragment_card_lay:
                break;
            case R.id.music_main_fragment_card_lately:
                break;
            case R.id.music_main_fragment_card_like:
                break;
            case R.id.music_main_fragment_card_recommend:
                break;
        }
    }
}
