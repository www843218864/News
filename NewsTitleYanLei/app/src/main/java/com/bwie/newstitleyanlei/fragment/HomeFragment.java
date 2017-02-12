package com.bwie.newstitleyanlei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/10 9:50
 */
public class HomeFragment extends Fragment {


    private TabLayout tab;
    private ViewPager pager;
    private List<Fragment> list;
    private String[] title = {"推荐", "热点", "阳光", "体育", "北京", "社会", "娱乐", "财经"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.home_fragment, null);
        tab = (TabLayout) view.findViewById(R.id.tab);
        pager = (ViewPager) view.findViewById(R.id.home_pager);

        list = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            NewsFragment fragment = new NewsFragment();
            list.add(fragment);
        }
        MyAdapter adapter = new MyAdapter(getActivity().getSupportFragmentManager(), list,title);
        pager.setAdapter(adapter);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setupWithViewPager(pager);


        return view;
    }
}
