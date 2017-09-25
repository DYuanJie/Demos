package com.dyjtest.drawabledemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainTab01 mTab01;
    private MainTab02 mTab02;
    private MainTab03 mTab03;

    private RadioButton radioButton0;
    private RadioButton radioButton1;
    private RadioButton radioButton2;

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
                radioButton0.setChecked(true);
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
                radioButton1.setChecked(true);
                if(mTab02 == null) {
                    //如果为空，则创建一个并添加到界面上
                    mTab02 = new MainTab02();
                    transaction.add(R.id.content, mTab02);
                }else {
                    // 如果不为空，则直接将它显示出来
                    transaction.show(mTab02);
                }
                break;
            case 2:
                radioButton2.setChecked(true);
                if(mTab03 == null){
                    mTab03 = new MainTab03();
                    transaction.add(R.id.content, mTab03);
                }else {
                    transaction.show(mTab03);
                }
        }
        transaction.commit();
    }

    //隐藏所有fragment
    private void hideFragments(FragmentTransaction transaction) {
        if(mTab01 != null){
            transaction.hide(mTab01);
        }
        if(mTab02 != null) transaction.hide(mTab02);
        if(mTab03 != null) transaction.hide(mTab03);
    }

    //清除所有选中状态
    private void resetBtn() {

        radioButton0.setChecked(false);
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
    }

    private void initViews() {
        radioButton0 = (RadioButton) findViewById(R.id.tab_btn0);
        radioButton1 = (RadioButton) findViewById(R.id.tab_btn1);
        radioButton2 = (RadioButton) findViewById(R.id.tab_btn2);
        radioButton0.setOnClickListener(this);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.tab_btn0:
                setTabSelection(0);
                break;
            case R.id.tab_btn1:
                setTabSelection(1);
                break;
            case R.id.tab_btn2:
                setTabSelection(2);
            default:
                break;
        }
    }

}
