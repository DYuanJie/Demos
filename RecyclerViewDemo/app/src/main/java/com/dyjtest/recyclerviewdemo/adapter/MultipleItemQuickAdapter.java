package com.dyjtest.recyclerviewdemo.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dyjtest.recyclerviewdemo.R;
import com.dyjtest.recyclerviewdemo.entity.MultipleItem;

import java.util.List;

/**
 * @author dingyj
 * @date 2017/9/18
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.multiple_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {

    }
}
