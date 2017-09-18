package com.dyjtest.recyclerviewdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dyjtest.recyclerviewdemo.R;

import java.util.List;

/**
 * baserecyclerviewAdaperViewHolder
 * @author dingyj
 * @date 2017/9/15
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public QuickAdapter(List<String> data) {
        super(R.layout.base_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.num_tv, s);

        //设置子控件的事件，要在adapter中绑定
        baseViewHolder.addOnClickListener(R.id.num_tv)
            .addOnLongClickListener(R.id.num_tv);
    }

}
