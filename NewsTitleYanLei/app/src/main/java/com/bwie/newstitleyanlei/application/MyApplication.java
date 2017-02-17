package com.bwie.newstitleyanlei.application;

import android.app.Application;
import android.graphics.Bitmap;

import com.bwie.newstitleyanlei.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import org.xutils.x;

/**
 * 1.类的用途：
 * 2.作者：闫雷
 * 3.2017/2/15 13:26
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(20))
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();


        //这样自定义设置后就可以管理二级缓存和三级缓存了
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(20)//设置占用内存的百分比
                .diskCacheFileCount(100)//设置最大下载图片数
                .diskCacheSize(5 * 1024 * 1024)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(configuration);//初始化完成


        //    ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        //   ImageLoader.getInstance().init(configuration);
    }
}
