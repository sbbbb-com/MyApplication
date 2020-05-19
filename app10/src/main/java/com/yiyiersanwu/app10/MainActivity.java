package com.yiyiersanwu.app10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MyHelper myHelper=null;
    //初始化数据库对象
    SQLiteDatabase db;

    private LinearLayout llName;
    private EditText etName;
    private LinearLayout llPhone;
    private EditText etPhone;
    private LinearLayout llBtn;
    private Button btnAdd;
    private Button btnQuery;
    private Button btnUpdate;
    private Button btnDelete;
    private TextView tvShow;

    List<UserInfo> uis=null;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2020-05-19 10:14:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        llName = (LinearLayout)findViewById( R.id.ll_name );
        etName = (EditText)findViewById( R.id.et_name );
        llPhone = (LinearLayout)findViewById( R.id.ll_phone );
        etPhone = (EditText)findViewById( R.id.et_phone );
        llBtn = (LinearLayout)findViewById( R.id.ll_btn );
        btnAdd = (Button)findViewById( R.id.btn_add );
        btnQuery = (Button)findViewById( R.id.btn_query );
        btnUpdate = (Button)findViewById( R.id.btn_update );
        btnDelete = (Button)findViewById( R.id.btn_delete );
        tvShow = (TextView)findViewById( R.id.tv_show );

        btnAdd.setOnClickListener( this );
        btnQuery.setOnClickListener( this);
        btnUpdate.setOnClickListener( this );
        btnDelete.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-05-19 10:14:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnAdd ) {
            // Handle clicks for btnAdd
            db=myHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            //向字段中添加字段值
            values.put("name",etName.getText().toString());
            values.put("phone",etPhone.getText().toString());
            //通过对象的方式来操作数据。

            db.insert("information",null,values);
            db.close();

            Toast.makeText(this, "添加数据成功", Toast.LENGTH_SHORT).show();

        } else if ( v == btnQuery ) {
            // Handle clicks for btnQuery
            //从数据库中查询所有的信息
            db=myHelper.getWritableDatabase();
            Cursor cursor = db.query("information", null, null, null, null, null, null);
            if (cursor.getCount()==0){
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }else {
                //遍历cursor，将每条记录封装到一个实体类对象UserInfo中
                //每次查询重新初始化集合
                uis=new ArrayList<>();

                UserInfo userInfo;
                while (cursor.moveToNext()){
                    userInfo=new UserInfo();
                    userInfo.setId(cursor.getInt(0));
                    userInfo.setName(cursor.getString(1));
                    userInfo.setPhone(cursor.getString(2));
                    //将对象放到集合中
                    uis.add(userInfo);

                }

                Toast.makeText(this, "查找记录"+uis.toString()+"=="+uis.size(), Toast.LENGTH_SHORT).show();
            }

        } else if ( v == btnUpdate ) {
            // Handle clicks for btnUpdate
        } else if ( v == btnDelete ) {
            // Handle clicks for btnDelete
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用初始化的方法
        findViews();

        //通过调用Myhelper 类创建数据库和表
        myHelper=new MyHelper(MainActivity.this,"db.sql",null,8);
        //调用写入的方法
        db=myHelper.getWritableDatabase();

    }
}
