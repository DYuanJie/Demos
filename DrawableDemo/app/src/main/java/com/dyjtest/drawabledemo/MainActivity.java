package com.dyjtest.drawabledemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainTab01 mTab01;
    private MainTab02 mTab02;

    private LinearLayout mTabShape;
    private LinearLayout mTabSelector;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);

    }

    //根据传入参数来设置tab页
    private void setTabSelection(int index) {
        resetBtn();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                if(mTab01 == null) {
                    //如果为空，则创建一个并添加到界面上
                    mTab01 = new MainTab01();
                    transaction.add(R.id.content, mTab01);
                }else {
                    // 如果不为空，则直接将它显示出来
                    transaction.show(mTab01);
                }
                break;
            case 1:
                if(mTab02 == null) {
                    //如果为空，则创建一个并添加到界面上
                    mTab02 = new MainTab02();
                    transaction.add(R.id.content, mTab02);
                }else {
                    // 如果不为空，则直接将它显示出来
                    transaction.show(mTab02);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有fragment
    private void hideFragments(FragmentTransaction transaction) {
        if(mTab01 != null){
            transaction.hide(mTab01);
        }
        if(mTab02 != null) transaction.hide(mTab02);
    }

    //清除所有选中状态
    private void resetBtn() {
    }

    private void initViews() {
        mTabShape = (LinearLayout) findViewById(R.id.tab_btn_shape);
        mTabSelector = (LinearLayout) findViewById(R.id.tab_btn_selector);
        mTabShape.setOnClickListener(this);
        mTabSelector.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tab_btn_shape:
                setTabSelection(0);
                break;
            case R.id.tab_btn_selector:
                setTabSelection(1);
                break;
            default:
                break;
        }
    }

}
