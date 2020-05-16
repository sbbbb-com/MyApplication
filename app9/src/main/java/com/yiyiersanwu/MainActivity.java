package com.yiyiersanwu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<WeatherInfo> weatherInfo =null;

    private TextView tvCity;
    private ImageView ivIcon;
    private TextView tvWeather;
    private TextView tvTemp;
    private TextView tvWind;
    private TextView tvPm;
    private LinearLayout llBtn;
    private Button btnBj;
    private Button btnSh;
    private Button btnGz;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2020-05-16 08:38:43 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        tvCity = (TextView)findViewById( R.id.tv_city );
        ivIcon = (ImageView)findViewById( R.id.iv_icon );
        tvWeather = (TextView)findViewById( R.id.tv_weather );
        tvTemp = (TextView)findViewById( R.id.tv_temp );
        tvWind = (TextView)findViewById( R.id.tv_wind );
        tvPm = (TextView)findViewById( R.id.tv_pm );
        llBtn = (LinearLayout)findViewById( R.id.ll_btn );
        btnBj = (Button)findViewById( R.id.btn_bj );
        btnSh = (Button)findViewById( R.id.btn_sh );
        btnGz = (Button)findViewById( R.id.btn_gz );

        //给三个按钮注册监听器
        btnBj.setOnClickListener( this );
        btnSh.setOnClickListener( this );
        btnGz.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-05-16 08:38:43 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnBj ) {
            // Handle clicks for btnBj
            //Toast.makeText(this, "北京", Toast.LENGTH_SHORT).show();
            showWeather(weatherInfo.get(1));
        } else if ( v == btnSh ) {
            // Handle clicks for btnSh
            //Toast.makeText(this, "上海", Toast.LENGTH_SHORT).show();
            showWeather(weatherInfo.get(0));
        } else if ( v == btnGz ) {
            // Handle clicks for btnGz
            //Toast.makeText(this, "广州", Toast.LENGTH_SHORT).show();
            showWeather(weatherInfo.get(2));
        }
    }

    //根据weather中数据显示响应的数据
    private void showWeather(WeatherInfo weatherInfo) {
        tvCity.setText(weatherInfo.getName());
        tvWeather.setText(weatherInfo.getWeather());
        tvPm.setText(weatherInfo.getPm());
        tvTemp.setText(weatherInfo.getTemp());
        tvWind.setText(weatherInfo.getWind());
        //显示不同的天气图片
        if ("晴转多云".equals(weatherInfo.getWeather())){
            ivIcon.setImageResource(R.drawable.cloud_sun);
        }else if ("晴".equals(weatherInfo.getWeather())){
            ivIcon.setImageResource(R.drawable.sun);
        }else if ("多云".equals(weatherInfo.getWeather())){
            ivIcon.setImageResource(R.drawable.clouds);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        findViews();

        //读取资源文件 json文件 解析文件
        //1.创建输入流对象
        InputStream is =null;
        is = this.getResources().openRawResource(R.raw.weather);

        try {
            //2.读取文件内容
            byte[] bytes = new byte[is.available()];
            //读取
            is.read(bytes);
            //将得到的byte转化为字符串 并且指定编码集
            String json = new String(bytes,"utf-8");
            //解析json文件
            //3.创建Gson对象
            Gson gson = new Gson();
            //4.获取要转换成的类型
            Type listType = new TypeToken<List<WeatherInfo>>(){}.getType();
            //将获取的类型的泛型类转成我们指定转换的类的泛型类
            weatherInfo = gson.fromJson(json, listType);
            //打印WeatherInfo  测试！！！！！
           /* if (weatherInfo!=null)   //防止空指针异常
            Toast.makeText(this, "打印WeatherInfo=="+weatherInfo.toString(), Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "打印WeatherInfo=="+weatherInfo, Toast.LENGTH_SHORT).show();*/

           //初始化设置
            showWeather(weatherInfo.get(1));


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
