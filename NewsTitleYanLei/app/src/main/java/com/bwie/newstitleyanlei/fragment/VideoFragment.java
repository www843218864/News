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
import com.bwie.newstitleyanlei.fragment.dataFragment.NewsFragment;
import com.bwie.newstitleyanlei.fragment.dataFragment.NewsVideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/10 9:50
 */
public class VideoFragment extends Fragment{

    private String[] title = {"热点时评", "娱乐视频", "搞笑视频", "精品视频"};
    private String[] str = {"V9LG4B3A0", "V9LG4CHOR", "V9LG4E6VR", "00850FRB"};
    private List<Fragment> list=null;
    private MyAdapter adapter;
    private TabLayout tab;
    private ViewPager pager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.video_fragment,null);

        tab = (TabLayout) view.findViewById(R.id.video_tab);
        pager = (ViewPager) view.findViewById(R.id.video_pager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            NewsVideoFragment fragment = new NewsVideoFragment();
            Bundle bundle=new Bundle();
            bundle.putString("id",str[i]);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        adapter = new MyAdapter(getActivity().getSupportFragmentManager(), list, title);
        pager.setAdapter(adapter);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setupWithViewPager(pager);

    }

}
