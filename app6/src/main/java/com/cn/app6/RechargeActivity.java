package com.cn.app6;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// 这是充值界面
public class RechargeActivity extends AppCompatActivity {
    Button button1;
    EditText et_recharge_money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        //分别初始化
        button1=findViewById(R.id.btn_recharge);
        et_recharge_money=findViewById(R.id.et_recharge_money);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当按下第二个界面的 “充值” 按钮后的操作
                //得到充值数值
                Intent intent=new Intent();
                intent.putExtra("recharge_Money",et_recharge_money.getText().toString());

                //向上一个activity回传数据
                setResult(RESULT_OK,intent);

                //结束当前activity，进入mainactivity的业务中
                RechargeActivity.this.finish();
            }
        });

    }
}
