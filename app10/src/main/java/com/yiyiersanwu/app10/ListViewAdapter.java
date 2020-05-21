package com.yiyiersanwu.app10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * 适配器
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<UserInfo> uis;



    //两个参数 构造方法 通过构造传递数据
    public ListViewAdapter(Context context, List<UserInfo> uis) {
        this.context=context;
        this.uis=uis;
    }
    //当写有参构造后，默认无参构造方法就没有了；

    //手写无参构造方法
    public ListViewAdapter() {
    }

    /**
     * @return 得到ListView中的显示的数据总数
     */
    @Override
    public int getCount() {
        return uis.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //得到与参数position相对应得布局视图，每一行就是一个view 单独做一个list-item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载用于列表项的布局文件
        //context是指上下文
        View view = View.inflate(context, R.layout.list_item, null);
        //从view对象中，获取控件
        TextView item_name=(TextView) view.findViewById(R.id.item_name);
        TextView item_phone=(TextView) view.findViewById(R.id.item_phone);
        CheckBox item_checkBox=view.findViewById(R.id.item_checkBox);
        //给view对象中的控件进行赋值  数据在uis中，他是一个集合数组，根据postition取当前的
        final UserInfo ui=uis.get(position);
        item_name.setText(ui.getName());
        item_phone.setText(ui.getPhone());

        //给复选框注册监听器  每一个复选框
        item_checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //处理点击事件  改变当前userinfo的ischecked值
                ui.setChecked(isChecked);
            }
        });

        return view;
    }
}
