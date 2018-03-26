package com.jiabiango.profits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiabiango.profits.dto.DemoQueryDto;
import com.jiabiango.profits.model.Demo;
import com.jiabiango.profits.pager.PageResult;
import com.jiabiango.profits.service.DemoServcie;

@RestController
@RequestMapping("/api")
public class ApiDemoController {
    @Autowired
    private DemoServcie demoServcie;
     
    @GetMapping("/demo")
    public PageResult<Demo> queryDemo(DemoQueryDto query) {
        return demoServcie.query(query);
    }
    
    @GetMapping("/demo/{id}")
    public Demo getDemo(@PathVariable("id") Integer id) {
        return demoServcie.get(id);
    }
    
    @PutMapping("/demo")
    public void updateDemo(@RequestBody Demo demo) {
        demoServcie.update(demo);
    }
    
    @PostMapping("/demo")
    public void saveDemo(@RequestBody Demo demo) {
        demoServcie.save(demo);
    }
}