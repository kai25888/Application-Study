package com.google.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tiankai on 2017/11/1.
 */
public class HttpDownLoad {

    /**
     * 从网络Url中下载文件
     */
    public String downLoadFromUrl(String urlStr) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream downloadfile = null;
        BufferedReader bufferedReader = null;
        try {
            downloadfile = getInputStreamFromURL(urlStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(new InputStreamReader(downloadfile));
        try {
            stringBuffer.append(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    /**
     * 从网络Url中下载其他文件(例如 MP3文件 等等)
     */
    public int downLoadFromUrl(String urlStr, String path, String fileName) {

        InputStream inputStream = null;
        try {
            FileUtils fileUtils = new FileUtils();

            if (fileUtils.isFileExist(path + fileName)) {
                return 1;
            } else {
                inputStream = getInputStreamFromURL(urlStr);
                File fileResult = fileUtils.writeToSDFromInput(path, fileName, inputStream);
                if (fileResult == null) {
                    return -1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 连接网络UrlStr,返回数据流
     */
    public InputStream getInputStreamFromURL(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlconn.getInputStream();
        return inputStream;
    }
}
