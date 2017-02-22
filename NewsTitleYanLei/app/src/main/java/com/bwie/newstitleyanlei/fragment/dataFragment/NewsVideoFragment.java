package com.bwie.newstitleyanlei.fragment.dataFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.adapter.VideoAdapter;
import com.bwie.newstitleyanlei.bean.VideoTop;
import com.bwie.newstitleyanlei.utils.VideoData;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by 闫雷 on 2017/2/22.
 */
public class NewsVideoFragment extends Fragment implements VideoData.VideoDataCallBack<List<VideoTop>>, PullToRefreshListView.OnRefreshListener2 {

    private PullToRefreshListView listView;
    private VideoAdapter adapter;
    private boolean isNeedClear;
    private int num = 0;
    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
        Log.e("AAAA",id);

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

        adapter = new VideoAdapter(getActivity());

        listView.setAdapter(adapter);
        VideoData.getVideoData(id, num, this);



    }

    private void initView(View view) {
        listView = (PullToRefreshListView) view.findViewById(R.id.pull_news);
    }


    @Override
    public void success(List<VideoTop> VideoTop) {


        adapter.addData(VideoTop, isNeedClear);
        adapter.notifyDataSetChanged();
        listView.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        num = 0;
        isNeedClear = true;
        VideoData.getVideoData(id, num, this);

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

        num = num + 10;
        isNeedClear = false;
        VideoData.getVideoData(id, num, this);
    }
}
