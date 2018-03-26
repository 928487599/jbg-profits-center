package com.jiabiango.profits.config.bean;

public class LayJsonResponseWrapper extends JsonResponseWrapper{
    private Integer count;
    private Object rows;
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Object getRows() {
        return rows;
    }
    public void setRows(Object rows) {
        this.rows = rows;
    }
    
}
