package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.SAX)
    Button SAX;
    @Bind(R.id.FULL)
    Button FULL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        System.out.println("finish");
        super.onDestroy();
    }

    @OnClick(R.id.SAX)
    public void onSAXClicked() {
    }

    @OnClick(R.id.FULL)
    public void onFULLClicked() {
    }
}
