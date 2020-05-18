package com.example.musicapp;

import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.musicapp.adapter.TabAdapter;
import com.example.musicapp.fragment.OffLineFragment;
import com.example.musicapp.fragment.OnlineFragment;
import com.example.musicapp.fragment.PlayingImageFragment;
import com.example.musicapp.fragment.PlayingLyricFragment;
import com.example.musicapp.fragment.ROffLineFragment;

import java.util.ArrayList;
import java.util.List;

public class PlayingActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private TabAdapter tabAdapter;
    private PlayingImageFragment playingImageFragment;
    private PlayingLyricFragment playingLyricFragment;

    String[] titles = new String[]{"专辑图片", "歌词"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        initView();

        tabAdapter = new TabAdapter(this.getSupportFragmentManager(),titles,mFragmentList);
        vp.setOffscreenPageLimit(2);//ViewPager的缓存为2帧
        vp.setAdapter(tabAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            LinearLayout ll_indicator = findViewById(R.id.ll_indicator);
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                //更新指示点的位置
                //先将所有指示点设置未选中
                ((ImageView) ll_indicator.getChildAt(0)).setImageTintList(getColorStateList(R.color.indicatorColor));
                ((ImageView) ll_indicator.getChildAt(1)).setImageTintList(getColorStateList(R.color.indicatorColor));
                //然后设置当前选中的指示点
                ((ImageView) ll_indicator.getChildAt(position)).setImageTintList(getColorStateList(R.color.white));
                Log.d("MusicDetail", "看这里------------------------？" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void initView(){


        vp = (ViewPager) findViewById(R.id.playingViewpager);
        playingImageFragment = new PlayingImageFragment();
        playingLyricFragment = new PlayingLyricFragment();
        mFragmentList.add(playingImageFragment);
        mFragmentList.add(playingLyricFragment);
    }
}


