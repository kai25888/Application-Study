package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    private Handler myhandler;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.begin)
    Button begin;
    @Bind(R.id.end)
    Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.begin)
    public void onBeginClicked() {
        progressBar.setVisibility(View.VISIBLE);
        HandlerThread handlerThread = new HandlerThread("handler_thread");
        handlerThread.start();
        myhandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    Message message = handler.obtainMessage();
                    message.arg1 = msg.arg1;
                    message.sendToTarget();
                    myhandler.post(runnable);
                }
            }
        };
        myhandler.post(runnable);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            title.setText("" + msg.arg1);
            progressBar.setProgress(msg.arg1);
        }
    };

    @OnClick(R.id.end)
    public void onEndClicked() {
        myhandler.removeCallbacks(runnable);
        progressBar.setVisibility(View.GONE);
    }

    Runnable runnable = new Runnable() {
        int i = 0;

        @Override
        public void run() {
            System.out.println("Thread ID is " + Thread.currentThread().getId() + " --- i = " + i);
            i = i + 10;
            Message message = myhandler.obtainMessage();
            message.arg1 = i;
            myhandler.sendMessageDelayed(message, 1000);
            if (i == 110) {
                System.out.println("i == 100 is over");
                myhandler.removeMessages(0);
            }
        }
    };

    @Override
    protected void onDestroy() {
        System.out.println("finish");
        super.onDestroy();
    }
}
