package com.dyjtest.recyclerviewdemo.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dyjtest.recyclerviewdemo.entity.MySection;

import java.util.List;

/**
 * @author dingyj
 * @date 2017/9/18
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {

    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
    }
}
