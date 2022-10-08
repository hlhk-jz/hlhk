package com.controller;
import cn.hutool.json.JSONObject;
import com.pojo.VehiclePojo;
import com.service.Test;
import com.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.Date;
import java.util.List;
@RestController
@Slf4j
public class TestController {
    @Autowired
    private Test test;
    @Autowired
    private TestService testService;

    @GetMapping("/sis/que")
    public Object sisQue(@RequestParam("str")String str){
        log.info("str = "+str);
        return "OK";
    }


     @GetMapping("/select/List")
    public Object selectList(){
         List list = testService.selectList();
         return list;
     }

     @GetMapping("/sis/test")
     public Object sisTest(HttpSession session){
         session.setMaxInactiveInterval(5);
         session.setAttribute("user","张三");
         return "OK";
     }

     @GetMapping("/query/test")
     public Object queryTest(){
         HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         Object user = request.getSession().getAttribute("user");
         return user;
     }

     @GetMapping("/test")
    public VehiclePojo vehiclePojo(){
         VehiclePojo vehiclePojo = new VehiclePojo();
         vehiclePojo.setDate(new Date());
         return vehiclePojo;
     }


     @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test4")
    public JSONObject show(){
        ResponseEntity<JSONObject> jsonObjectResponseEntity = restTemplate.postForEntity("http://localhost:9005/test1", new JSONObject(), JSONObject.class);
        return  jsonObjectResponseEntity.getBody();
    }


}
