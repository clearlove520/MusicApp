package com.example.musicapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicapp.MainActivity;
import com.example.musicapp.R;
import com.example.musicapp.entity.Song;
import com.example.musicapp.util.LocalMusicUtils;

import java.util.List;

public class PlayListAdapter extends BaseAdapter{
    private List<Song> songList;
    private LayoutInflater layoutInflater;
    private Context context;
    public PlayListAdapter(List<Song> songList,Context context){
        this.songList = songList;
        this.context = context;
        this.layoutInflater =LayoutInflater.from(context) ;
    }

    @Override
    public int getCount() {
        return songList == null ? 0 : songList.size();
    }

    @Override
    public Object getItem(int position) {
        return songList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view  = layoutInflater.inflate(R.layout.item_music_list,null);
        Song song = (Song) getItem(position);

        ImageView musicCover = (ImageView) view.findViewById(R.id.musicCover);
        TextView musicName = (TextView) view.findViewById(R.id.musicName);
        TextView singer = (TextView) view.findViewById(R.id.singer);
        System.out.println("song.getAlbumId()");

        LocalMusicUtils localMusicUtils = new LocalMusicUtils();
        Bitmap bm = localMusicUtils.getArtwork(this.context,song.getId(),song.getAlbumId(),true,true);
        System.out.println(bm);
        System.out.println("song.getAlbumId()");
        System.out.println(song.getAlbumId());
        musicCover.setImageBitmap(bm);
        musicName.setText(song.getName());
        singer.setText(song.getSinger());

        return view;

    }
}