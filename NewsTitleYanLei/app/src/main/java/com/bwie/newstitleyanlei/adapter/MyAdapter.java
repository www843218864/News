package com.bwie.newstitleyanlei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/12 20:09
 */
public class MyAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private String[] title;

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    public MyAdapter(FragmentManager fm, List<Fragment> list, String[] title) {
        super(fm);
        this.list = list;
        this.title = title;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
