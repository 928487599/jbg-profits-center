package com.jiabiango.profits.pager;

import java.util.Collections;
import java.util.List;

public class PageResult<T> extends PageParam {
    private int total;
    private List<T> list = Collections.emptyList();
    
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }

}
