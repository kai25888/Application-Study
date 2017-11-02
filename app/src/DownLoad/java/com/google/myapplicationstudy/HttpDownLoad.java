package com.google.myapplicationstudy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by tiankai on 2017/11/1.
 */
public class HttpDownLoad {

    /**
     * 从网络Url中下载文件
     */
    public void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URI url = null;
        try {
            url = new URI(urlStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn = ;

    }
}
