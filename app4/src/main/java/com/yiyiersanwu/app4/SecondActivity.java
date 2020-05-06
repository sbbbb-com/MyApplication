package com.yiyiersanwu.app4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

        Bundle myBundle = getIntent().getBundleExtra("myBundle");
        String demo = myBundle.getString("demo");
        int bun_int = myBundle.getInt("bun_int");
        TextView commentCount=findViewById(R.id.tv_comment_count);
        commentCount.setText(demo+bun_int);



    }
}
