package com.cn.app6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //初始化获得金额中数值绑定
    TextView tv_current_money ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        Button btn_goto_recharge = (Button) findViewById(R.id.btn_goto_recharge);
        View viewById = findViewById(R.id.et_recharge_money);
        tv_current_money= findViewById(R.id.tv_current_money);
        //设置按钮的监听事件
        btn_goto_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过显是意图跳转到RechargeActivity充值界面
                Intent intent = new Intent(MainActivity.this, RechargeActivity.class);

                // 启动Activity
                startActivityForResult(intent, 1000);  // 1000是个任意整数，代表请求码
            }
        });
    }

    //处理第二个activity回传的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获得默认保存的金额
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            //取出回传数据
            int recharge_money = Integer.parseInt(data.getStringExtra("recharge_Money"));
            //获得当前金额
            int currentMoney = Integer.parseInt(tv_current_money.getText().toString());
            //最新的金额
            currentMoney+=recharge_money;
            //将最新金额重新设置进去
            tv_current_money.setText(currentMoney+"");
        }
    }
}

