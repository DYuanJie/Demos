package com.dyjtest.recyclerviewdemo.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * @author dingyj
 * @date 2017/9/18
 */

public class MySection extends SectionEntity<String> {
    public MySection(String s) {
        super(s);
    }

    public MySection(boolean isHeader, String header) {
        super(isHeader, header);
    }
}
