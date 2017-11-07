package com.google.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by tiankai on 2017/11/7.
 */
public class BroadcastReceiver_Manual extends android.content.BroadcastReceiver{
    public BroadcastReceiver_Manual() {
        System.out.println("BroadcastReceiver_Manual structure");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("BroadcastReceiver_Manual onReceive");
        StringBuffer message = new StringBuffer();
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
//        SmsMessage[] smsMessages =  new SmsMessage[pdus.length];

        if(pdus == null) System.out.println("pdus is null");
        System.out.println(pdus.length);
        for(Object pdu : pdus){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
            if(smsMessage == null)continue;
            System.out.println(smsMessage.getDisplayMessageBody());
            message.append(smsMessage.getDisplayMessageBody());
        }
        System.out.println(message);
        System.gc();
        System.gc();
    }
}
