package com.google.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by tiankai on 2017/11/7.
 */
public class BroadcastReceiver_Auto extends android.content.BroadcastReceiver{
    public BroadcastReceiver_Auto() {
        System.out.println("BroadcastReceiver_Auto structure ");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("BroadcastReceiver_Auto onReceive ");
    }
}
