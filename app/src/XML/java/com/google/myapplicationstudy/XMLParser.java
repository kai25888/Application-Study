package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tiankai on 2017/11/1.
 */
public class XMLParser extends Activity {
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.onCreateDataBase)
    Button onCreateDataBase;
    @Bind(R.id.updateDataBase)
    Button updateDataBase;
    @Bind(R.id.main_layout)
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.onCreateDataBase)
    public void onOnCreateDataBaseClicked() {
    }

    @OnClick(R.id.updateDataBase)
    public void onUpdateDataBaseClicked() {
    }

    @OnClick(R.id.main_layout)
    public void onMainLayoutClicked() {
    }
}
