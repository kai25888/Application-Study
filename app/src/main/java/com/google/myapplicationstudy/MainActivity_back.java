package com.google.myapplicationstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity_back extends Activity {
    @Bind(R.id.onCreateDataBase)
    Button onCreateDataBase;
    @Bind(R.id.updateDataBase)
    Button updateDataBase;
    @Bind(R.id.write)
    Button write;
    @Bind(R.id.insert)
    Button insert;
    @Bind(R.id.query)
    Button query;
    @Bind(R.id.title)
    TextView title;

    //    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        System.out.println(title.getText());
    }

    @OnClick(R.id.onCreateDataBase)
    public void onOnCreateDataBaseClicked() {
        title.setText("onCreateDataBase");
    }

    @OnClick(R.id.updateDataBase)
    public void onUpdateDataBaseClicked() {
        title.setText("updateDataBase");
    }

    @OnClick(R.id.write)
    public void onWriteClicked() {
        title.setText("Write");
    }

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        title.setText("Insert");
    }

    @OnClick(R.id.query)
    public void onQueryClicked() {
        title.setText("Query");
    }

    @Override
    protected void onDestroy() {
        System.out.println("finish");
        super.onDestroy();
    }
}
