package com.yiyiersanwu.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

@SuppressWarnings("All")
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView paramsTextView=findViewById(R.id.tv_paras);
//        String names = getIntent().getStringExtra("demo");
//        paramsTextView.setText(names);
//
//
//        int comment_count = getIntent().getIntExtra("comment_count",-1);
//        TextView commentCount=findViewById(R.id.tv_comment_count);
//        commentCount.setText(comment_count+"");

//        Bundle myBundle = getIntent().getBundleExtra("myBundle");
//        String demo = myBundle.getString("demo");
//        int bun_int = myBundle.getInt("bun_int");
//        TextView commentCount=findViewById(R.id.tv_comment_count);
//        commentCount.setText(demo+bun_int);

//        UserInfo userInfo = (UserInfo) getIntent().getSerializableExtra("userInfo");
//        paramsTextView.setText(userInfo.toString());

//        Parcelable order =(Order) getIntent().getParcelableExtra("order");
//        paramsTextView.setText(order.toString());

//        Intent intent=new Intent();
//        intent.putExtra("back_data","这是一段回传的数据");
//        setResult(RESULT_OK,intent);
    }
}
