package com.cn.app8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //定义变量信息
    EditText et_content;//备忘录信息
    ImageButton btn_save; //保存按钮
    ImageButton btn_cancel;//取消按钮


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化按钮变量
        et_content=findViewById(R.id.et_content);
        btn_save=findViewById(R.id.btn_save);
        btn_cancel=findViewById(R.id.btn_cancel);

        //读取文件 加载到记事本中
        FileInputStream fis=null;
        String content;
        try {
            //绑定输入流
            fis=openFileInput("mydata.dat");
            byte[] buffer = new byte[fis.available()];  //获得文件字节数可取大小
            fis.read(buffer);
            content=new String(buffer);
            //把读取到的数据显示在控件上
            et_content.setText(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //写入操作
        //给保存按钮注册监听器
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用内部存储实现文件存储
                //1.获取写入内容
                String content = et_content.getText().toString();
                //2.声明输出流对象
                FileOutputStream fos =null;
                try {
                    //定义流对象
                    fos = openFileOutput("mydata.dat", MODE_PRIVATE);
                    //向文件中写入内容
                    fos.write(content.getBytes());
                    fos.flush();
                    Toast.makeText(MainActivity.this, "写入成功！！", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (fos!=null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


    }
}
