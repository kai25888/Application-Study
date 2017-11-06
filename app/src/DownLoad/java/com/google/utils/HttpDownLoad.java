package com.google.utils;

import android.content.Context;

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
    public String downLoadFromUrl(Context context , String urlStr) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream downloadfile = null;
        BufferedReader bufferedReader = null;
        String fileName = "temp.txt";
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
        FileUtils fileUtils = new FileUtils(context);
        if (fileUtils.isFileExist(fileName)) {
            System.out.println("file is exist");
        }else{
            if(downloadfile != null)
                System.out.println("inputstream is no null" + " fileName : " + fileName);
            File fileResult = fileUtils.writeToSDFromInput(null, fileName, downloadfile);
            if (fileResult == null) {
                System.out.println("file write is fail");
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 从网络Url中下载其他文件(例如 MP3文件 等等)
     */
    public int downLoadFromUrl(Context context , String urlStr, String path, String fileName) {

        InputStream inputStream = null;
        try {
            FileUtils fileUtils = new FileUtils(context);
            System.out.println(fileUtils.getSDPATH());
            if (fileUtils.isFileExist(fileName)) {
                return 1;
            } else {
                inputStream = getInputStreamFromURL(urlStr);
                if(inputStream != null)
                    System.out.println("inputstream is no null" + " path : " + path + " fileName : " + fileName);
                File fileResult = fileUtils.writeToSDFromInput(path, fileName, inputStream);
                if (fileResult == null) {
                    System.out.println("fileResult is null");
                    return -1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catch IOException");
            return -1;
        }finally {
            try {
                if(inputStream != null)
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
