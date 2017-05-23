package com.bawey.kgf.zhibo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mList;
    private String[] mTitles;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mList,String[] mTitles) {
        super(fm);
        this.mList = mList;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
}