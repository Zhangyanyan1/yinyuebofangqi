package com.example.lenovo.yinyuebofangqi.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.yinyuebofangqi.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yinm_pc on 2017/6/30.
 */

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> list;

    @Inject
    public SongListAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_song_list_text)
        TextView itemSongListText;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_song_list, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemSongListText.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
