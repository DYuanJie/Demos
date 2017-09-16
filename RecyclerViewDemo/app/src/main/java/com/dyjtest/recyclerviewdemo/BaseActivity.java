package com.dyjtest.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private RecyclerView baseRv;
    private QuickAdapter quickAdapter;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initDatas();
        baseRv = (RecyclerView) findViewById(R.id.base_rv);
        quickAdapter = new QuickAdapter(mDatas);
        baseRv.setLayoutManager(new GridLayoutManager(this, 3));
        baseRv.setAdapter(quickAdapter);

        //item的点击事件
        quickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BaseActivity.this, position + "click", Toast.LENGTH_SHORT).show();
            }
        });

        //item的长按事件
        quickAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BaseActivity.this, position + "longclick", Toast.LENGTH_SHORT).show();
                return false;
            }
        });




    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++){
            mDatas.add("" + (char)i);
        }
    }
}
