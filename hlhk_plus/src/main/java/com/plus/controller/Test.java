package com.plus.controller;

import com.plus.entty.TestEntty;
import com.plus.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class Test {
    @Autowired
    private TestService testService;

    @GetMapping("/query/data/{id}")
    public Object queryData(@PathVariable Long id){
        String str = testService.queryData(id);
        return str;
    }

    @PostMapping("/select/data")
    public Object selectData(@RequestBody Map<String, String> map){
        String id = map.get("id");
        String name = map.get("name");
        String str = testService.selectData(id,name);
        return str;
    }

    @DeleteMapping("/del/{id}")
    public void deleId(@PathVariable Long id){
        testService.deleId(id);
    }

    @GetMapping("/test")
    public Object test(){
        List<TestEntty> list = testService.selectList();
        return list;
    }
    @GetMapping("/pages")
    public Object pages(){
        return testService.pages();
    }
}
