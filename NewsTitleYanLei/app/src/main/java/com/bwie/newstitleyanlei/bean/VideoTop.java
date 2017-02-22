package com.bwie.newstitleyanlei.bean;

/**
 * Created by 闫雷 on 2017/2/22.
 */
public class VideoTop {
    private String mp4_url;
    private String cover;
    private String title;
    private String topicName;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public VideoTop(String cover, String mp4_url, String title, String topicName) {
        this.cover = cover;
        this.mp4_url = mp4_url;
        this.title = title;
        this.topicName = topicName;
    }
}
