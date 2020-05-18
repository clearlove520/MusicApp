package com.example.musicapp.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.musicapp.MainActivity;
import com.example.musicapp.R;
import com.example.musicapp.adapter.PlayListAdapter;
import com.example.musicapp.entity.Song;
import com.example.musicapp.util.LocalMusicUtils;

import java.util.ArrayList;
import java.util.List;

public class OffLineFragment extends ListFragment {
    private LocalMusicUtils localMusicUtils;
    private List<Song> songs;



    public OffLineFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //申请权限咯
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else {
            getLocalMusicData();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("songs2");
        return inflater.inflate(R.layout.fragment_offlinelist, container, false);



    }

    /**
     * 获取本地存储的音乐
     */
    private void getLocalMusicData() {

                localMusicUtils = new LocalMusicUtils();
                songs = localMusicUtils.getmusic(getActivity());

                PlayListAdapter playListAdapter  = new PlayListAdapter(songs,getActivity());
                System.out.println("playListAdapter");
                System.out.println(playListAdapter.getCount());
                setListAdapter(playListAdapter);
//                //异步消息处理机制
//                Message message = new Message();
//                message.what = 1;
//                handler.sendMessage(message);

    }



   /**
    * 申请权限
    */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    getLocalMusicData();
                }else {
                    Toast.makeText(getActivity(), "请允许扫描本地文件", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
