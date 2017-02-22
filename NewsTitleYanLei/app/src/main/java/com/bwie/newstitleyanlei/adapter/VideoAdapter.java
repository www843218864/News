package com.bwie.newstitleyanlei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.bean.Imgextra;
import com.bwie.newstitleyanlei.bean.NewsTop;
import com.bwie.newstitleyanlei.bean.VideoTop;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 闫雷 on 2017/2/16.
 */
public class VideoAdapter extends BaseAdapter {
    private List<VideoTop> list = new ArrayList<>();
    private Context context;

    public VideoAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.video_data, null);
            holder.jcVideoPlayerStandard = (JCVideoPlayerStandard) convertView.findViewById(R.id.custom_videoplayer_standard);
            holder.text = (TextView) convertView.findViewById(R.id.text_video);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.jcVideoPlayerStandard.setUp(list.get(position).getMp4_url(),list.get(position).getTitle());
        holder.text.setText(list.get(position ).getTopicName());
        ImageLoader.getInstance().displayImage(list.get(position).getCover(),holder.jcVideoPlayerStandard.thumbImageView);


        return convertView;
    }

    class ViewHolder {
        private TextView text;
        private JCVideoPlayerStandard jcVideoPlayerStandard;

    }

    public void addData(List<VideoTop> list2, boolean isNeedClear) {

        if (list2 != null) {
            if (isNeedClear) {
                list.clear();

            }
            list.addAll(list2);


        }

    }
}
