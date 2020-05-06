package com.cn.app3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button butBaiDu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //百度按钮的设置
         butBaiDu=findViewById(R.id.but_baidu);
         butBaiDu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //直接转到百度网页
                 Intent intent=new Intent();
                 //设置动作
                 intent.setAction("android.intent.action.VIEW");
                 //设置要打开网页
                 intent.setData(Uri.parse("http://www.baidu.com"));
                 startActivity(intent);
             }
         });

         //拨打电话
        butBaiDu=findViewById(R.id.but_tel);
        butBaiDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:"+15959595);
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        //发送短信
        butBaiDu=findViewById(R.id.but_manager);
        butBaiDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //12215电话号码
                //message 信息
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+122155));
                intent.putExtra("sms_body", "message");
                startActivity(intent);
            }
        });
    }
}
