package com.example.asus.finaldesginer.util;

import okhttp3.OkHttpClient;

/**
 * Created by ASUS on 2018/2/27.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}


