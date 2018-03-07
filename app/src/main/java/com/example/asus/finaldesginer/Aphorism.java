package com.example.asus.finaldesginer;

/**
 * Created by ASUS on 2018/2/25.
 */

public class Aphorism {
    private String name;
    private int imageId;
    public Aphorism(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
