package com.controller;
import cn.hutool.core.util.RandomUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WxTest {
    public static List<Integer> list = new ArrayList<>();
    static {
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);



        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);


        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);

        list.add(5);
        list.add(5);
    }

    public static int num = 0;
    @GetMapping("/wuxing/test")
    public Integer get(){
        int c = RandomUtil.randomEle(list);
        num ++;
        return c;
    }
}
