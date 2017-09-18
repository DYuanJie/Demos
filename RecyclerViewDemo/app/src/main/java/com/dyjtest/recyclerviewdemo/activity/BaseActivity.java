package com.dyjtest.recyclerviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dyjtest.recyclerviewdemo.R;
import com.dyjtest.recyclerviewdemo.adapter.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private RecyclerView baseRv;
    private QuickAdapter quickAdapter;
    private List<String> mDatas;
    private static int pageNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initDatas();
        baseRv = (RecyclerView) findViewById(R.id.base_rv);
        quickAdapter = new QuickAdapter(mDatas);
//        baseRv.setLayoutManager(new GridLayoutManager(this, 3));
        baseRv.setLayoutManager(new LinearLayoutManager(this));
        baseRv.setAdapter(quickAdapter);

        /*点击事件 开始*/
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
                return true;
            }
        });

        //item子控件的点击事件
        quickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BaseActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
            }
        });

        //item子控件的长按事件
        quickAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BaseActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        /*点击事件 结束*/

       /* 动画 开始*/

        //开启动画(默认为渐显效果) （渐显、缩放、从下到上，从左到右、从右到左）
//        quickAdapter.openLoadAnimation();
        //切换动画
        quickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //自定义动画
//        quickAdapter.openLoadAnimation(new BaseAnimation() {
//            @Override
//            public Animator[] getAnimators(View view) {
//                return new Animator[]{
//                        ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
//                        ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
//                };
//            }
//
//        });
        //动画默认只执行一次,如果想重复执行可设置
        quickAdapter.isFirstOnly(false);
        //设置不显示动画数量 用来设置第一屏item不执行动画
        quickAdapter.setNotDoAnimationCount(5);
        /*动画 结束*/

        /*自动加载 开始*/
        //上拉加载 滑动最后一个Item的时候回调onLoadMoreRequested方法
        quickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if(pageNum < 3) {
                    quickAdapter.addData(mDatas);
                    //加载完成
                    quickAdapter.loadMoreComplete();
                    pageNum++;
                }else {
                    //加载结束
                    quickAdapter.loadMoreEnd();
                    //加载失败
//                    quickAdapter.loadMoreFail();
                }
            }
        });
        //打开或关闭加载（一般用于下拉的时候做处理，因为上拉下拉不能同时操作）
//        quickAdapter.setEnableLoadMore(false);
        //预加载 当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
//        quickAdapter.setPreLoadNumber(5);
        //设置自定义加载布局
//        quickAdapter.setLoadMoreView();

        //下拉加载 设置开启开关
//        quickAdapter.setUpFetchEnable(true);
        //设置监听
        quickAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                startUpFetch();
            }
        });
        //开始加载的位置
        quickAdapter.setStartUpFetchPosition(2);

    }

    private void startUpFetch() {
        pageNum++;
        quickAdapter.setUpFetching(true);
        baseRv.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(pageNum < 3){
                    quickAdapter.addData(0, mDatas);
                    quickAdapter.setUpFetchEnable(false);
                    Toast.makeText(BaseActivity.this, "下拉加载", Toast.LENGTH_SHORT).show();
                }else {
                    quickAdapter.setUpFetchEnable(false);
                }
            }
        }, 300);

        /*自动加载 结束*/



    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'; i++){
            mDatas.add("" + (char)i);
        }
    }
}
