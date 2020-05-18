package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.musicapp.adapter.PlayListAdapter;
import com.example.musicapp.adapter.TabAdapter;
import com.example.musicapp.entity.Song;
import com.example.musicapp.fragment.OffLineFragment;
import com.example.musicapp.fragment.OnlineFragment;
import com.example.musicapp.fragment.ROffLineFragment;
import com.example.musicapp.util.LocalMusicUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView item_offline, item_online;
    private ViewPager vp;
    private OffLineFragment offLineFragment;
    private OnlineFragment onlineFragment;
    private ROffLineFragment rOffLineFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private TabAdapter tabAdapter;

    private LocalMusicUtils localMusicUtils;
    private  List<Song> songs;
    String[] titles = new String[]{"本地音乐", "在线音乐"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SpannableStringBuilder builder = null;
       // ForegroundColorSpan Span = new ForegroundColorSpan(0X333333);
       // builder.setSpan(Span,0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        initViews();


        tabAdapter = new TabAdapter(this.getSupportFragmentManager(),titles,mFragmentList);
        vp.setOffscreenPageLimit(2);//ViewPager的缓存为2帧
        vp.setAdapter(tabAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ImageView toPlayList = findViewById(R.id.toPlayList);
        ImageView toPlaying = findViewById(R.id.toPlaying);
        toPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(intent);

            }
        });

        toPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });



    }

    //初始化布局
    public void initViews() {
        item_offline = (TextView) findViewById(R.id.offline_music);
        item_online = (TextView) findViewById(R.id.online_music);
        item_offline.setSelected(true);

        item_offline.setOnClickListener(this);
        item_online.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewpager);
        offLineFragment = new OffLineFragment();
        onlineFragment = new OnlineFragment();
        rOffLineFragment = new ROffLineFragment();
        mFragmentList.add(rOffLineFragment);
        mFragmentList.add(onlineFragment);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.offline_music:
                vp.setCurrentItem(0, true);
                item_offline.setSelected(true);
                item_online.setSelected(false);
                break;
            case R.id.online_music:
                vp.setCurrentItem(1, true);
                item_offline.setSelected(false);
                item_online.setSelected(true);
                break;
        }
    }



}
