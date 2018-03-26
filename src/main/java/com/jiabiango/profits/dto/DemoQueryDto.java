package com.jiabiango.profits.dto;

import com.jiabiango.profits.pager.PageParam;

public class DemoQueryDto extends PageParam{
    private String name;
    private String title;
    private Integer status;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
