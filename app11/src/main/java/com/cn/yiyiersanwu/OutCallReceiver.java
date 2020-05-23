package com.cn.yiyiersanwu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver {

    public OutCallReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //获取拨出的电话
        String outcallnumber = getResultData();
        //获取事先要拦截的电话
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        //取值
        String number = sp.getString("number", "-1");

        //判断
        if (outcallnumber!=null)
        if (outcallnumber.equals(number)){
            //拦截电话
            setResultData(null);
        }
    }
}
