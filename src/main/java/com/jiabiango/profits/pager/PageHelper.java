package com.jiabiango.profits.pager;

import com.baomidou.mybatisplus.plugins.Page;

public class PageHelper {
    public static <T> PageResult<T> toPageResult(Page<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNo(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setList(page.getRecords());
        return pageResult;
    }
    
    public static <T> LayPageResult<T> toLayPageResult(Page<T> page) {
        LayPageResult<T> pageResult = new LayPageResult<>();
        pageResult.setPageNo(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setList(page.getRecords());
        return pageResult;
    }
    
    public static <T> Page<T> toPage(PageParam pageParam) {
        Page<T> page = new Page<>();
        page.setCurrent(pageParam.getPageNo());
        page.setSize(pageParam.getPageSize());
        return page;
    }
}
