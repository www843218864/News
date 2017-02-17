package com.bwie.newstitleyanlei.fragment.dataFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.activity.WebViewActivity;
import com.bwie.newstitleyanlei.adapter.MyBaseAdapter;
import com.bwie.newstitleyanlei.bean.NewsTop;

import com.bwie.newstitleyanlei.utils.HttPData;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;


/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/12 20:03
 */
public class NewsFragment extends Fragment implements HttPData.HttpDataCallBack<List<NewsTop>>, PullToRefreshListView.OnRefreshListener2 {

    private PullToRefreshListView listView;
    private MyBaseAdapter adapter;
    private boolean isNeedClear;
    private int num = 0;
    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.news_item, null);
        initView(view);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(this);

        adapter = new MyBaseAdapter(getActivity());
        listView.setAdapter(adapter);

        HttPData.getData(id, num, this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsTop newsTop= (NewsTop) adapter.getItem(position-1);
                Log.e("position",position+"");
                String url = newsTop.getUrl_3w();
                Intent intent=new Intent(getActivity(), WebViewActivity.class);

                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }

    private void initView(View view) {
        listView = (PullToRefreshListView) view.findViewById(R.id.pull_news);
    }


    @Override
    public void success(List<NewsTop> newsTops) {

        adapter.addData(newsTops, isNeedClear);
        adapter.notifyDataSetChanged();
        listView.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        num = 0;
        isNeedClear = true;
        HttPData.getData(id, num, this);

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

        num = num + 10;
        isNeedClear = false;
        HttPData.getData(id, num, this);
    }

}
