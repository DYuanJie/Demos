package com.dyjtest.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.dyjtest.fragmentdemo.fragment.Tab01Fragment;
import com.dyjtest.fragmentdemo.fragment.Tab02Fragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private FrameLayout content;
    private Tab01Fragment tab01Fragment;
    private Tab02Fragment tab02Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        //设置默认fragment
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        tab01Fragment = new Tab01Fragment();
        ft.replace(R.id.content, tab01Fragment);
        ft.commit();
    }

    private void initViews() {
        content = (FrameLayout) findViewById(R.id.content);
        radioGroup = (RadioGroup) findViewById(R.id.menu_group);

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (i){
            case R.id.radio_btn_01:
                if(tab01Fragment == null){
                    tab01Fragment = new Tab01Fragment();
                }
                ft.replace(R.id.content, tab01Fragment);
                break;
            case R.id.radio_btn_02:
                if(tab02Fragment == null){
                    tab02Fragment = new Tab02Fragment();
                }
                ft.replace(R.id.content, tab02Fragment);
                break;
        }
        ft.commit();
    }
}
