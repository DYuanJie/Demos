package com.dyjtest.recyclerviewdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dyjtest.recyclerviewdemo.DividerGridItemDecoration;
import com.dyjtest.recyclerviewdemo.R;
import com.dyjtest.recyclerviewdemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;
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
        mainRv.setLayoutManager(new LinearLayoutManager(this));//线性
//        mainRv.setLayoutManager(new GridLayoutManager(this, 4));//网格式
//        mainRv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));//瀑布流式

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
                //点击事件
                Toast.makeText(MainActivity.this, position + "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //长按事件
                Toast.makeText(MainActivity.this, position + "longclick", Toast.LENGTH_SHORT).show();
            }
        });

        //拖曳与滑动删除
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = 0;//拖曳标志
                if(recyclerView.getLayoutManager() instanceof LinearLayoutManager){
                    //线性布局，只有UP/DOWN
                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                }else {
                    //网格布局瀑布、流布局有UP/DOWN/LEFT/RIGHT四个方向
                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
                }
//                int swipeFlags = 0;//滑动标志，拖曳时设为0，暂不考虑
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;//滑动
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            //拖曳过程中不断回调此方法
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();//拖动的item的下标
                int toPosition = target.getAdapterPosition();//目标item的下标

                if(fromPosition == 0){
                    return false;
                }
                if(toPosition == 0){
                    return false;
                }
                //交换item的下标
                if(fromPosition < toPosition){
                    for (int i = fromPosition; i < toPosition; i++){
                        Collections.swap(mData, i, i+1);
                    }
                }else {
                    for (int i = fromPosition; i > toPosition; i--){
                        Collections.swap(mData, i, i-1);
                    }

                }

                myAdapter.notifyItemMoved(fromPosition, toPosition);

                return true;
            }

            //滑动删除的回调
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int adapterPosition = viewHolder.getAdapterPosition();
                mData.remove(adapterPosition);
                myAdapter.notifyItemRemoved(adapterPosition);
            }

            //是否支持长按拖曳
//            @Override
//            public boolean isLongPressDragEnabled() {
//                return false;
//            }
        });
        itemTouchHelper.attachToRecyclerView(mainRv);



    }

    //标题栏菜单
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
            case R.id.base_recyclerview:
                Intent intent = new Intent(this, BaseActivity.class);
                startActivity(intent);
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
