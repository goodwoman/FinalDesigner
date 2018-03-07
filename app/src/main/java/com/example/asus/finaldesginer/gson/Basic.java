package com.example.asus.finaldesginer.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2018/2/27.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }


}
