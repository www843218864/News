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

    private String[] title = {"推荐", "足球", "娱乐", "体育", "财经", "科技", "电影", "汽车"};
    private String[] str = {"T1348647909107", "T1399700447917", "T1348648517839", "T1348649079062", "T1348648756099", "T1348649580692", "T1348648650048", "T1348654060988"};
    private List<Fragment> list=null;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.home_fragment, null);
        tab = (TabLayout) view.findViewById(R.id.tab);
        pager = (ViewPager) view.findViewById(R.id.home_pager);


        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            NewsFragment fragment = new NewsFragment();
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
