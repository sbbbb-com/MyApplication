package com.cn.yiyiersanwu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView et_ipnumber;
    private Button btn_save;
    private SharedPreferences sp;

    private OutCallReceiver receiver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册广播接收器
        //1.实例化广播接收器
        receiver = new OutCallReceiver();
        //在意图IntentFilter对象中，定义一个系统广播
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_NEW_OUTGOING_CALL");
        intentFilter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);
        intentFilter.setPriority(Integer.MAX_VALUE);

        //注册接收器
        registerReceiver(receiver,intentFilter);


        //初始化控件
        et_ipnumber=findViewById(R.id.et_ipnumber);
        btn_save=findViewById(R.id.btn_save);
        
        //注册监听器
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取拦截的字符串
                String number = et_ipnumber.getText().toString();
                //初始化SharedPreferences
                sp=getSharedPreferences("config",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("number",number);
                editor.commit();

                //提示信息
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
