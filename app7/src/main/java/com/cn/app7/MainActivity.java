package com.cn.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //定义按钮和变量
    EditText et_username;
    EditText et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //读取SharedPreferences文件中数据 获取用户名和密码
       final SharedPreferences sp_sd = getSharedPreferences("ui", MODE_PRIVATE);
        String username = sp_sd.getString("username",null);
        String password = sp_sd.getString("password", null);

        if ("root".equals(username) && "123".equals(password)){
            //跳转到欢迎界面  登陆成功界面
            Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
            startActivity(intent);

        }

        //初始化按钮和变量值
        et_password=findViewById(R.id.et_password);
        et_username=findViewById(R.id.et_username);
        btn_login=findViewById(R.id.btn_login);

        //给按钮添加监听事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当按下按钮时判读密码和账号是否正确
                //获取用户名密码和账号
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                //校验
                if ("root".equals(username) && "123".equals(password)){
                    //合法用户，将用户信息存入到SharedPreferences中
                    //1.获取SharedPreferences对象
                    final SharedPreferences sp = getSharedPreferences("ui", MODE_PRIVATE);
                    //2.创建editor对象
                    SharedPreferences.Editor editor = sp.edit();
                    //3.向对象中添加数据
                    editor.putString("username",username);
                    editor.putString("password",password);
                    //4.提交
                    editor.commit();
                    //editor.apply();
                    //给出提示
                    Toast.makeText(MainActivity.this, "账号密码验证保存成功！", Toast.LENGTH_SHORT).show();
                    //跳转欢迎界面
                    startActivity(new Intent(MainActivity.this,WelcomeActivity.class));

                    //错误
                }else Toast.makeText(MainActivity.this, "用户名或密码错误，请检查后重新输入！！", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
