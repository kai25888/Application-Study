package com.google.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by tiankai on 2017/11/3.
 */
public class FileUtils {
    private String SDPATH;

    /**
     * 返回SDcard路径
     */
    public void FileUtils() {
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }

    public String getSDPATH() {
        return SDPATH;
    }

    /**
     * 创建新目录
     */
    private File creatSDDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * 创建新文件
     */
    private File creatSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * @param fileName
     */
    public boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        Boolean bl =  file.exists();
        return bl;
    }

    /**
     *
     */
    public File writeToSDFromInput(String path, String fileName, InputStream input) {
        File file = null;
        OutputStream outputStream = null;
        try {
            creatSDDir(path);
            file = creatSDFile(path + fileName);
            outputStream = new FileOutputStream(file);
            byte buffer[] = new byte[4 * 1024];
            while (input.read(buffer) != -1) {
                outputStream.write(buffer);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

}
