package com.shangma.cn.common.page;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private long total;
    private List<T> data;

    private PageBean(long total, List<T> data){
        this.data = data;
        this.total = total;
    }

    public static <T> PageBean<T> initData(long total, List<T> data){
        return new PageBean<T>(total, data);
    }

}
