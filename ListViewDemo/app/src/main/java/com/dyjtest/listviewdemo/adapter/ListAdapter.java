package com.dyjtest.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dyjtest.listviewdemo.R;
import com.dyjtest.listviewdemo.model.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dingyj
 * @date 2017/9/28
 */

public class ListAdapter extends BaseAdapter {

    private List<Bean> mData = new ArrayList<Bean>();
    private Context mContext;
    private Map<Integer, Boolean> isCheck = new HashMap<Integer, Boolean>();

    public ListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
        //默认不选中
        initCheck(false);
    }

    public void initCheck(boolean flag) {
        for (int i = 0; i < mData.size(); i++){
            isCheck.put(i, flag);
        }
    }

    public void setmData(List<Bean> mData) {
        this.mData = mData;
    }

    public void addData(Bean data) {
        //在头部添加数据
        mData.add(0, data);
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        View view = null;
        //判断是否第一次进入
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.item_title);
            viewHolder.checkBox = (CheckBox)view.findViewById(R.id.item_checkBox);
            //标记，可复用
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        Bean bean = mData.get(i);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheck.put(i, b);
            }
        });
        //设置状态
        if(isCheck.get(i) == null){
            isCheck.put(i, false);
        }
        viewHolder.checkBox.setChecked(isCheck.get(i));
        return view;
    }

    //优化
    public static class ViewHolder{
        public TextView title;
        public CheckBox checkBox;
    }

    //全选按钮获取状态
    public Map<Integer, Boolean> getMap() {
        return isCheck;
    }

    //删除一个数据
    public void removeData(int position) {
        mData.remove(position);
    }
}
