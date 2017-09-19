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


    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
        //绑定type和layout的关系
        addItemType(MultipleItem.TEXT, R.layout.multiple_item);
        addItemType(MultipleItem.IMG, R.layout.multiple_item1);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()){
            case MultipleItem.TEXT:
                helper.setText(R.id.text1, "111");
                break;
            case MultipleItem.IMG:
                helper.setImageResource(R.id.mul_iv, R.drawable.desert);
                break;
        }
    }
}
