package com.bwie.newstitleyanlei.utils;

/**
 * Created by 闫雷 on 2017/2/16.
 */
public class UrlPath {


    public static String getUri(String id,int num1){


        String uri="http://c.m.163.com/nc/article/headline/"+id+"/"+num1+"-20.html";

        return uri;
    }
    public static String getUrlTwo(String id,int num1){


        String uri="http://c.3g.163.com/nc/video/list/"+id+"/n/"+num1+"-10.html";

        return uri;
    }


}
