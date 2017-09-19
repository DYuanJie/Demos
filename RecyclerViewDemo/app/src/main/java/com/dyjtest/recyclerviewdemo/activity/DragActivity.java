package com.dyjtest.recyclerviewdemo.activity;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.dyjtest.recyclerviewdemo.R;
import com.dyjtest.recyclerviewdemo.adapter.DragAdapter;

import java.util.ArrayList;
import java.util.List;

public class DragActivity extends AppCompatActivity {

    private List<String> mDatas;
    private RecyclerView dragRv;
    private DragAdapter dragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);

        intDatas();
        dragRv = (RecyclerView) findViewById(R.id.dragRv);
        dragAdapter = new DragAdapter(mDatas);
        //拖曳
        intDrag();
        dragRv.setLayoutManager(new LinearLayoutManager(this));
        dragRv.setAdapter(dragAdapter);


    }

    private void intDrag() {
        //拖曳回调
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {}

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {}

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
        };

        //滑动回调
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {}

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {}

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {}

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {}
        };
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(dragAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(dragRv);

        //开启拖曳
        dragAdapter.enableDragItem(itemTouchHelper, R.id.num_tv, true);
        dragAdapter.setOnItemDragListener(onItemDragListener);

        //开启滑动删除
        dragAdapter.enableSwipeItem();
        dragAdapter.setOnItemSwipeListener(onItemSwipeListener);


    }

    private void intDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 15; i++){
            mDatas.add("" + i);
        }
    }
}
