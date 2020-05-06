package com.yiyiersanwu.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.btn_sta);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                /*intent.putExtra("demo","安卓开发");
                intent.putExtra("comment_count",118);*/
                Bundle bundle=new Bundle();
                bundle.putString("demo","通过bundle传递的值");
                bundle.putInt("bun_int",1396);
                intent.putExtra("myBundle",bundle);


                startActivity(intent);
            }
        });
    }
}
