package com.example.musicapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    //tab文字标题
    private String[] mTabData;
    //需要显示的Fragment的集合
    private List<Fragment> mfragmentList;

    public TabAdapter(FragmentManager fm, String[] tabData, List<Fragment> fragmentList) {
        super(fm);
        this.mTabData = tabData;
        this.mfragmentList = fragmentList;
    }


    //根据position返回需要显示的Fragment
    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }
    //获取需要显示Fragment的数据量，有几个标题就肯定有几个Fragment，所以直接拿数组的长度就可以了
    @Override
    public int getCount() {
        return mTabData.length;
    }
    //返回tab的标题文字数据
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabData[position];
    }
}