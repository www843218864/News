package com.bwie.newstitleyanlei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newstitleyanlei.R;
import com.bwie.newstitleyanlei.bean.Imgextra;
import com.bwie.newstitleyanlei.bean.NewsTop;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫雷 on 2017/2/16.
 */
public class MyBaseAdapter extends BaseAdapter {
    private List<NewsTop> list = new ArrayList<>();
    private Context context;
    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;

    public MyBaseAdapter(Context context) {

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
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        Imgextra imgextra = list.get(position).getImgextra();
        if (imgextra != null) {
            return TYPE_1;
        }
        return TYPE_2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHolder();
            if (type == TYPE_1) {
                convertView = View.inflate(context, R.layout.data2_item, null);
                holder.text1= (TextView) convertView.findViewById(R.id.title_text);
                holder.text2= (TextView) convertView.findViewById(R.id.source_text);
                holder.text3= (TextView) convertView.findViewById(R.id.replyCount_text);
                holder.image1= (ImageView) convertView.findViewById(R.id.imageview1);
                holder.image2= (ImageView) convertView.findViewById(R.id.imageview2);
                holder.image3= (ImageView) convertView.findViewById(R.id.imageview3);
                convertView.setTag(holder);
            } else {
                convertView = View.inflate(context, R.layout.data_item, null);
                holder.text1= (TextView) convertView.findViewById(R.id.title_text);
                holder.text2= (TextView) convertView.findViewById(R.id.source_text);
                holder.text3= (TextView) convertView.findViewById(R.id.replyCount_text);
                holder.image1= (ImageView) convertView.findViewById(R.id.imageview);
                convertView.setTag(holder);
            }

        }else{

                holder= (ViewHolder) convertView.getTag();

        }
        if(type==TYPE_1){
            holder.text1.setText(list.get(position).getTitle());
            holder.text2.setText(list.get(position).getSource());
            holder.text3.setText("  评论"+list.get(position).getReplyCount());
            ImageLoader.getInstance().displayImage(list.get(position).getImgsrc(),holder.image1);
            ImageLoader.getInstance().displayImage(list.get(position).getImgextra().getImageOne(),holder.image2);
            ImageLoader.getInstance().displayImage(list.get(position).getImgextra().getImageOne(),holder.image3);

        }else{
            holder.text1.setText(list.get(position).getTitle());
            holder.text2.setText(list.get(position).getSource());
            holder.text3.setText("  评论"+list.get(position).getReplyCount());
            ImageLoader.getInstance().displayImage(list.get(position).getImgsrc(),holder.image1);
        }


        return convertView;
    }

    class ViewHolder {
        private TextView text1, text2, text3;
        private ImageView image1, image2, image3;

    }

    public void addData(List<NewsTop> list2, boolean isNeedClear) {

        if (list2 != null) {
            if (isNeedClear) {
                list.clear();

            }
            list.addAll(list2);



        }

    }
}
