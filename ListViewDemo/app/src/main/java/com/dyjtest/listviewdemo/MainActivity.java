package com.dyjtest.listviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dyjtest.listviewdemo.adapter.ListAdapter;
import com.dyjtest.listviewdemo.model.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mainAdd;
    private Button btnDelete;
    private Button btnSelectAll;
    private ListView mainLv;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    //模拟数据
    private void initData() {
        List<Bean> mData = new ArrayList<>();
        mData.add(new Bean("小明"));
        mData.add(new Bean("小红"));
        mData.add(new Bean("小绿"));
        mData.add(new Bean("小黑"));

        listAdapter = new ListAdapter(this);
        listAdapter.setmData(mData);
        mainLv.setAdapter(listAdapter);
    }

    private void initView() {
        mainAdd = (TextView) findViewById(R.id.main_add);
        btnDelete = (Button) findViewById(R.id.main_delete);
        btnSelectAll = (Button) findViewById(R.id.main_select_all);
        mainLv = (ListView) findViewById(R.id.main_lv);

        mainAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSelectAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_add:
                listAdapter.addData(new Bean("001"));
                listAdapter.notifyDataSetChanged();
                break;
            case R.id.main_select_all:
                Map<Integer, Boolean> isCheck = listAdapter.getMap();
                if("全选".equals(btnSelectAll.getText())){
                    listAdapter.initCheck(true);
                    listAdapter.notifyDataSetChanged();
                    btnSelectAll.setText("全不选");
                    btnSelectAll.setTextColor(Color.BLACK);
                }else {
                    listAdapter.initCheck(false);
                    listAdapter.notifyDataSetChanged();
                    btnSelectAll.setText("全选");
                    btnSelectAll.setTextColor(Color.WHITE);
                }
                break;
            case R.id.main_delete:
                // 拿到所有数据
                Map<Integer, Boolean> isCheck_delete = listAdapter.getMap();
                // 获取到条目数量，map.size = list.size,所以
                int count = listAdapter.getCount();
                // 遍历
                for (int i = 0; i < count; i++) {
                    // 删除有两个map和list都要删除 ,计算方式
                    int position = i - (count - listAdapter.getCount());
                    // 判断状态 true为删除
                    if (isCheck_delete.get(i) != null && isCheck_delete.get(i)) {
                        // listview删除数据
                        isCheck_delete.remove(i);
                        listAdapter.removeData(position);
                    }
                }
                btnSelectAll.setText("全选");
                btnSelectAll.setTextColor(Color.WHITE);
                listAdapter.notifyDataSetChanged();
                break;
        }
    }
}
