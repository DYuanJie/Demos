package com.dyjtest.fragmentdemo.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dyjtest.fragmentdemo.R;

/**
 * @author dingyj
 * @date 2017/9/29
 */

public class Tab02Fragment extends Fragment {
    private TextView tv01;
    private TextView tv02;
    private TextView tv03;
    private TextView tv04;
    private TextView tv05;
    private TextView tv06;
    private TextView tv07;
    private TextView tv08;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab02, container, false);
        initViews(view);
        doForm01();
        doForm02();
        doForm03();
        doForm04();
        doForm05();
        doForm06();
        doForm07();
        doForm08();

        return view;
    }

    //链接
    private void doForm08() {
        SpannableString spannableString = new SpannableString("点我打开超链接。");
        URLSpan urlSpan = new URLSpan("www.baidu.com");
        //重写onClick方法
        spannableString.setSpan(urlSpan, 4, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        tv08.setMovementMethod(LinkMovementMethod.getInstance());
        tv08.setText(spannableString);
    }

    //点击
    private void doForm07() {
        SpannableString spannableString = new SpannableString("点击我试试。");
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "试试就试试", Toast.LENGTH_SHORT).show();
            }
        }, 3, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv07.setMovementMethod(LinkMovementMethod.getInstance());//要设置后才能点击
        tv07.setText(spannableString);

    }

    //表情
    private void doForm06() {
        SpannableString spannableString = new SpannableString("这样也可以？表情（表情）");
        Drawable drawable = getActivity().getResources().getDrawable(R.mipmap.meng);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv06.setText(spannableString);
    }

    //上下标，粗体、斜体
    private void doForm05() {
        SpannableString spannableString = new SpannableString("这个是上标(粗体)，这个是下标（斜体）");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_A = new StyleSpan(Typeface.ITALIC);

        spannableString.setSpan(superscriptSpan, 3, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan_B, 3, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(subscriptSpan, 13, 15, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan_A, 13, 15, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        tv05.setText(spannableString);
    }

    //字体大小
    private void doForm03() {
        SpannableString spannableString = new SpannableString("字体大小改变");

        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(1f);

        spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan02, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan03, 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan04, 3, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan05, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(sizeSpan06, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        tv03.setText(spannableString);

    }


    //删除线，下划线
    private void doForm04() {
        SpannableString spannableString = new SpannableString("这是删除线，这是下划线");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(strikethroughSpan, 2, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(underlineSpan, 8, spannableString.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        tv04.setText(spannableString);
    }

    //背景色
    private void doForm02() {
        SpannableString spannableString = new SpannableString("背景色长长长长长长长长长");
        BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan, 0, 3, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv02.setText(spannableString);
    }

    //前景色
    private void doForm01() {
        SpannableString spannableString = new SpannableString("前景色长长长长长长长长长");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(colorSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv01.setText(spannableString);
    }

    private void initViews(View view) {
        tv01 = (TextView)view.findViewById(R.id.spannable_string_01);
        tv02 = (TextView)view.findViewById(R.id.spannable_string_02);
        tv03 = (TextView)view.findViewById(R.id.spannable_string_03);
        tv04 = (TextView)view.findViewById(R.id.spannable_string_04);
        tv05 = (TextView)view.findViewById(R.id.spannable_string_05);
        tv06 = (TextView)view.findViewById(R.id.spannable_string_06);
        tv07 = (TextView)view.findViewById(R.id.spannable_string_07);
        tv08 = (TextView)view.findViewById(R.id.spannable_string_08);
    }
}
