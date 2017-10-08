package com.dyjtest.fragmentdemo.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyjtest.fragmentdemo.R;

/**
 * @author dingyj
 * @date 2017/9/29
 */

public class Tab01Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab01, container, false);
        SpannableString spannableString = new SpannableString("这是一段长长长长长长的文字");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#aa000000"));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099ee"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        TextView tv = (TextView)view.findViewById(R.id.spannablestring_tv);
        tv.setText(spannableString);
        return view;
    }
}
