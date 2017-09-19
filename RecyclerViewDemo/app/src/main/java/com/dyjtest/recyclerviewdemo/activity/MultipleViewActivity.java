package com.dyjtest.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyjtest.recyclerviewdemo.R;
import com.dyjtest.recyclerviewdemo.adapter.MultipleItemQuickAdapter;
import com.dyjtest.recyclerviewdemo.entity.MultipleItem;

import java.util.ArrayList;
import java.util.List;

public class MultipleViewActivity extends AppCompatActivity {

    private RecyclerView mulRv;
    private MultipleItemQuickAdapter multipleItemQuickAdapter;
    private List<MultipleItem> multipleItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view);

        mulRv = (RecyclerView) findViewById(R.id.mulRv);
        mulRv.setLayoutManager(new LinearLayoutManager(this));

        initDatas();

        multipleItemQuickAdapter = new MultipleItemQuickAdapter(multipleItems);
        mulRv.setAdapter(multipleItemQuickAdapter);
    }

    private void initDatas() {
        multipleItems = new ArrayList<>();
        multipleItems.add(new MultipleItem(MultipleItem.IMG));
        multipleItems.add(new MultipleItem(MultipleItem.TEXT));
        multipleItems.add(new MultipleItem(MultipleItem.IMG));
        multipleItems.add(new MultipleItem(MultipleItem.TEXT));
        multipleItems.add(new MultipleItem(MultipleItem.IMG));
    }
}
