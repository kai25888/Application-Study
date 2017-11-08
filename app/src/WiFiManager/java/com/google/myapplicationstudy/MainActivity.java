package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tiankai on 2017/11/8.
 */
public class MainActivity extends Activity {
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.enablewifi)
    Button enablewifi;
    @Bind(R.id.stopwifi)
    Button stopwifi;
    @Bind(R.id.getwifistatus)
    Button getwifistatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifimanager_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.enablewifi)
    public void onEnablewifiClicked() {
    }

    @OnClick(R.id.stopwifi)
    public void onStopwifiClicked() {
    }

    @OnClick(R.id.getwifistatus)
    public void onGetwifistatusClicked() {
    }
}
