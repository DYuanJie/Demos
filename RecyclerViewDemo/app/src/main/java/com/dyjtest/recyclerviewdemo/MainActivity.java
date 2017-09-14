package com.dyjtest.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mData;
    private RecyclerView mainRv;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        mainRv = (RecyclerView) findViewById(R.id.main_rv);
        myAdapter = new MyAdapter(mData);

        //布局管理
//        mainRv.setLayoutManager(new LinearLayoutManager(this));//线性
//        mainRv.setLayoutManager(new GridLayoutManager(this, 4));//网格式
        mainRv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));//瀑布流式

        //adapter
        mainRv.setAdapter(myAdapter);

        //分割线
        mainRv.addItemDecoration(new DividerGridItemDecoration(this));

        //设置item动画
        mainRv.setItemAnimator(new DefaultItemAnimator());

        //点击监听
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + "longclick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                myAdapter.addData(1);
                break;
            case R.id.remove:
                myAdapter.removeData(1);
                break;
        }
        return true;
    }

    private void initDatas() {
        mData = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++){
            mData.add("" + (char)i);
        }
    }
}
