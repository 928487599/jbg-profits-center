package com.jiabiango.profits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jiabiango.profits.dto.DemoQueryDto;
import com.jiabiango.profits.mapper.DemoMapper;
import com.jiabiango.profits.model.Demo;
import com.jiabiango.profits.pager.LayPageResult;
import com.jiabiango.profits.pager.PageHelper;

@Service
public class DemoServcie {
    @Autowired
    private DemoMapper demoMapper;

    public LayPageResult<Demo> query(DemoQueryDto query) {
        Page<Demo> page = PageHelper.toPage(query);
        List<Demo> list = demoMapper.query(page,query);
        page.setRecords(list);
        return PageHelper.toLayPageResult(page);
    }

    public Demo get(Integer id) {
        return demoMapper.selectByPrimaryKey(id);
    }

    public void update(Demo demo) {
        demoMapper.updateByPrimaryKeySelective(demo);
        
    }

    public void save(Demo demo) {
        demoMapper.insert(demo);
    }

}
