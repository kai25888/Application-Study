package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.utils.HttpDownLoad;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.down_file)
    Button downFile;
    @Bind(R.id.down_other)
    Button downOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_main);
        ButterKnife.bind(this);
        System.out.println("Tread ID is " + Thread.currentThread().getId());
    }

    @OnClick(R.id.down_file)
    public void onDownFileClicked() {
        Thread thread = new Thread(runnable1);
        thread.start();
//        runnable1.run();
//        thread1.start();
    }

    @OnClick(R.id.down_other)
    public void onDownOtherClicked() {
        Thread thread = new Thread(runnable2);
        thread.start();
//        runnable2.run();
//        thread2.start();
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            Log.d("nico", "Tread ID is " + Thread.currentThread().getId());
            System.out.println("Tread ID is " + Thread.currentThread().getId());
            HttpDownLoad httpDownLoad = new HttpDownLoad();
            String downloadstring = httpDownLoad.downLoadFromUrl("http://down1.txt99.com/d/file/p/txt/2017/%E9%87%8D%E5%9B%9E%E7%8E%B0%E4%BB%A3.txt");
            System.out.println(downloadstring);
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            Log.d("nico", "Tread ID is " + Thread.currentThread().getId());
            System.out.println("Tread ID is " + Thread.currentThread().getId());
            HttpDownLoad httpDownLoad = new HttpDownLoad();
            Integer result = httpDownLoad.downLoadFromUrl("https://downloads.atlassian.com/software/sourcetree/windows/ga/SourceTreeSetup-2.3.1.0.exe?_ga=2.173518820.618492512.1509689593-514979525.1509689593", "application", "sourcetree");
            System.out.println("download is " + result);
        }
    });

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            Log.d("nico", "Tread ID is " + Thread.currentThread().getId());
            System.out.println("Tread ID is " + Thread.currentThread().getId());
            HttpDownLoad httpDownLoad = new HttpDownLoad();
            String downloadstring = httpDownLoad.downLoadFromUrl("http://down1.txt99.com/d/file/p/txt/2017/%E9%87%8D%E5%9B%9E%E7%8E%B0%E4%BB%A3.txt");
            System.out.println(downloadstring);
        }
    };
    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            Log.d("nico", "Tread ID is " + Thread.currentThread().getId());
            System.out.println("Tread ID is " + Thread.currentThread().getId());
            HttpDownLoad httpDownLoad = new HttpDownLoad();
            Integer result = httpDownLoad.downLoadFromUrl("https://downloads.atlassian.com/software/sourcetree/windows/ga/SourceTreeSetup-2.3.1.0.exe?_ga=2.173518820.618492512.1509689593-514979525.1509689593", "application", "sourcetree");
            System.out.println("download is " + result);
        }
    };
}
