package com.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/test1")
    public Object getOne()throws Exception{
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:9005/test2", Map.class);
        //DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:/sipin.mp4"));
        return forEntity.getBody();
    }

    @GetMapping("/test2")
    public JSONObject test2()throws Exception{
        System.out.println("=======================执行了=======================");
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("name","张三");
        jsonObject.set("age","33");
        return jsonObject;
    }
}
