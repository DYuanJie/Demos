package com.dyjtest.recyclerviewdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyjtest.recyclerviewdemo.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button normal;
    private Button base;
    private Button multiple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        normal = (Button) findViewById(R.id.normal);
        base = (Button) findViewById(R.id.base);
        multiple = (Button) findViewById(R.id.multiple);

        normal.setOnClickListener(this);
        base.setOnClickListener(this);
        multiple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.base:
                startActivity(new Intent(this, BaseActivity.class));
                break;
            case R.id.multiple:
                startActivity(new Intent(this, MultipleViewActivity.class));
                break;
            default:
                break;
        }
    }
}
