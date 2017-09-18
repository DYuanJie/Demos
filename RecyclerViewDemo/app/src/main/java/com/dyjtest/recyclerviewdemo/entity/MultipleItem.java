package com.dyjtest.recyclerviewdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author dingyj
 * @date 2017/9/18
 */

public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType;

    public  MultipleItem(int itemType){
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
