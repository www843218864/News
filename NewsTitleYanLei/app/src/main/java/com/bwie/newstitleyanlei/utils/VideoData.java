package com.bwie.newstitleyanlei.utils;


import android.util.Log;

import com.bwie.newstitleyanlei.bean.VideoTop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 闫雷 on 2017/2/16.
 */
public class VideoData {

    public static void getVideoData(String id, int num1, final VideoDataCallBack videoDataCallBack) {
        final String url = UrlPath.getUrlTwo(id, num1);

        Log.e("LLLL",id+"-------");
        x.http().get(new RequestParams(url), new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                List<VideoTop> list=new ArrayList<VideoTop>();
                Log.e("BBBB",list.toString());
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    Iterator<String> keys = jsonObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray jsonArray = jsonObject.getJSONArray(next);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String cover = object.getString("cover");
                            String mp4_url = object.getString("mp4_url");
                            String title = object.getString("title");
                            String topicName = object.getString("topicName");
                            VideoTop videoTop=new VideoTop(cover,mp4_url,title,topicName);
                            list.add(videoTop);

                        }
                        videoDataCallBack.success(list);

                        Log.e("CCCC",list.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });


    }

    public interface VideoDataCallBack<T> {
        void success(T t);
    }
}
