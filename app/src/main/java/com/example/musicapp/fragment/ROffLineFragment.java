package com.example.musicapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.adapter.PlayListAdapter;
import com.example.musicapp.adapter.RPlayListAdapter;
import com.example.musicapp.entity.Song;
import com.example.musicapp.util.LocalMusicUtils;

import java.util.List;

public class ROffLineFragment extends Fragment {
    private LocalMusicUtils localMusicUtils;
    private RecyclerView recyclerView;
    private List<Song> songs;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_offlinelist_r, container, false);
        context = view.getContext();

         recyclerView = view.findViewById(R.id.collect_recyclerView);

         getLocalMusicData();
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RPlayListAdapter rplayListAdapter  = new RPlayListAdapter(context,songs);
        System.out.println("playListAdapter");

        recyclerView.setAdapter(rplayListAdapter);
        recyclerView.setLayoutManager(manager);
         return view;
    }


    /**
     * 获取本地存储的音乐
     */
    private void getLocalMusicData() {

        localMusicUtils = new LocalMusicUtils();
        songs = localMusicUtils.getmusic(getActivity());




//                //异步消息处理机制
//                Message message = new Message();
//                message.what = 1;
//                handler.sendMessage(message);

    }

}
