package com.dyjtest.recyclerviewdemo.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dyjtest.recyclerviewdemo.R;

import java.util.List;

/**
 * @author dingyj
 * @date 2017/9/19
 */

public class DragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public DragAdapter(List<String> data) {
        super(R.layout.base_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.num_tv, item);
    }
}
