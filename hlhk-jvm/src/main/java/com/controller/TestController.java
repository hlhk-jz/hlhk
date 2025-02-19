package com.controller;

import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    public static Map<String,byte[]>  map = new HashMap<>();
    //堆内存溢出，一直new对象
    @GetMapping("/dui")
    public void show1(){
         while (true){
             byte[] buffer = new byte[1024*1024]; // 1GB大小的数组
             map.put(System.currentTimeMillis()+"", buffer);
         }
     }
}
