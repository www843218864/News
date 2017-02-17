package com.bwie.newstitleyanlei.bean;

/**
 * Created by 闫雷 on 2017/2/16.
 */
public class Imgextra {
    private String imageOne;
    private String imageTwo;

    public Imgextra(String imageOne, String imageTwo) {
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    @Override
    public String toString() {
        return "Imgextra{" +
                "imageOne='" + imageOne + '\'' +
                ", imageTwo='" + imageTwo + '\'' +
                '}';
    }
}
