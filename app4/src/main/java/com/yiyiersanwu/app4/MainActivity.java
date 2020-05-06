package com.yiyiersanwu.app4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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
//                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//                intent.putExtra("demo","安卓开发");
//                intent.putExtra("comment_count",118);

//                Bundle bundle=new Bundle();
//                bundle.putString("demo","通过bundle传递的值");
//                bundle.putInt("bun_int",1396);
//                intent.putExtra("myBundle",bundle);

//                UserInfo userInfo=new UserInfo("张三",48,"男");
//                intent.putExtra("userInfo",userInfo);

//                Order order=new Order("aa88","扬州",98);
//                intent.putExtra("order",order);
//                startActivity(intent);

//                startActivityForResult(intent,100);
                Intent intent1=new Intent();

                //拨打电话
               // intent1.setAction(Intent.ACTION_DIAL);

                //发送短信
//                Uri parse = Uri.parse("smsto:" + 123);
//                intent1.setAction(Intent.ACTION_SENDTO);
//                intent1.setData(parse);
//                intent1.putExtra("sms_body","短信内容 哈哈");
//                startActivity(intent1);

                //打开相机
                intent1.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent1);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        String backData=data.getStringExtra("back_data");
//        Log.e("MainActivity","onActivityResult requestCode="+requestCode+",back_data======="+backData);
//    }


}
