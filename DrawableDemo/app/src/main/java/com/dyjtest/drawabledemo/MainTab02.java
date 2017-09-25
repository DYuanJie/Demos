package com.dyjtest.drawabledemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * selector样式
 * @author dingyj
 * @date 2017/9/23
 */

public class MainTab02 extends Fragment{
    private ListView mainTab02Lv;
    private List<String> mData;
    private ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maintab_02, container, false);
        mainTab02Lv = (ListView)view.findViewById(R.id.mainTab02Lv);
        initData();

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1);
        adapter.addAll(mData);
        mainTab02Lv.setAdapter(adapter);

        return view;

    }


    private void initData() {
        mData = new ArrayList<>();
        for (int i = 'a'; i < 'e'; i++){
            mData.add("" + (char)i);
        }
    }


}
