package com.google.myapplicationstudy;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.utils.BroadcastReceiver_Manual;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tiankai on 2017/11/7.
 */
public class MainActivity extends Activity {
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.auto_register)
    Button autoRegister;
    @Bind(R.id.manual_register)
    Button manualRegister;
    @Bind(R.id.manual_unregister)
    Button manualUnregister;

    public final static String EXTRA_MESSAGE = "\"android.intent.action.MESSAGE";
    private BroadcastReceiver_Manual br_manaul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcastreceiver_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.auto_register)
    public void onAutoRegisterClicked() {
        System.out.println("onAutoRegisterClicked");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        MainActivity.this.sendBroadcast(intent);
    }

    @OnClick(R.id.manual_register)
    public void onManualRegisterClicked() {
        br_manaul = new BroadcastReceiver_Manual();
        IntentFilter intentfilter = new IntentFilter(EXTRA_MESSAGE);
        this.registerReceiver(br_manaul,intentfilter);
    }

    @OnClick(R.id.manual_unregister)
    public void onManualUnregisterClicked() {
        System.out.println("manual_unregister");
        this.unregisterReceiver(br_manaul);
    }
}
