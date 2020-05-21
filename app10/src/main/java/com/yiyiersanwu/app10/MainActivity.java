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
import android.widget.ListView;
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
    private ListView lvShow;

    List<UserInfo> uis=null;
    //适配器的声明
    ListViewAdapter adapter=null;

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
        lvShow = (ListView)findViewById( R.id.lv_show );

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
            //执行查询操作
            btnQuery.callOnClick();

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
            }

            db.close();
            adapter=new ListViewAdapter(MainActivity.this,uis);
            //设置适配器
            lvShow.setAdapter(adapter);

        } else if ( v == btnUpdate ) {
            // Handle clicks for btnUpdate
        } else if ( v == btnDelete ) {
            // 删除选中的记录
            db=myHelper.getWritableDatabase();
            for (int i = 0; i <uis.size() ; i++) {
                UserInfo ui = uis.get(i);
                //判断当前ui对象中的属性值 ischecked 符合条件删除
                if (ui.isChecked()!=null){
                    db.delete("information","_id=?",new String[]{ui.getId()+""});
                }
            }

            db.close();
            //执行查询按钮  按下按钮callOnClick  自动更新
            btnQuery.callOnClick();
            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
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
