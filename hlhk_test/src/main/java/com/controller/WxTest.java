package com.controller;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.UserData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
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
    private final Logger logger = LoggerFactory.getLogger(WxTest.class);

    public static int num = 0;
    @GetMapping("/wuxing/test")
    public Integer get(){
        int c = RandomUtil.randomEle(list);
        num ++;
        log.info("随机数:{}",c);
        return c;
    }

    private final String LOGIN_KEY = "LOGIN_KEY";
    @Autowired
    private StringRedisTemplate redisTemplate;
    @PostMapping("/wuxing/login")
    public JSONObject login(@RequestBody JSONObject jsonObject){
        jsonObject.put("code",501 );
        String strList = redisTemplate.opsForValue().get(LOGIN_KEY);
        String userName = jsonObject.get("userName").toString();
        String passWord = jsonObject.get("passWord").toString();
        if(!StringUtils.isEmpty(strList)){
            List<UserData> userData = JSONArray.parseArray(strList, UserData.class);
            userData.stream().forEach(po->{
                if(po.getUserName().equals(userName) && po.getPassWord().equals(passWord)){
                   jsonObject.put("token",userName);
                   jsonObject.put("code",200 );
                }
            });
        }
        return jsonObject;
    }

    @PostMapping("/wuxing/save")
    public JSONObject save(@RequestBody JSONObject jsonObject){
        String userName = jsonObject.get("userName").toString();
        String passWord = jsonObject.get("passWord").toString();
        String strList = redisTemplate.opsForValue().get(LOGIN_KEY);
        List<UserData> userDataList = new ArrayList<>();
        if(!StringUtils.isEmpty(strList)){
            userDataList = JSONArray.parseArray(strList, UserData.class);
            if(10 <= userDataList.size()){
                jsonObject.put("msg","注册失败用户空间已满" );
                jsonObject.put("code",501 );
                return jsonObject;
            }
        }
        UserData userData1 = new UserData();
        userData1.setPassWord(passWord);
        userData1.setUserName(userName);
        userDataList.add(userData1);
        redisTemplate.opsForValue().set(LOGIN_KEY,JSON.toJSONString(userDataList));
        jsonObject.put("token",userName );
        jsonObject.put("code",200 );
        return jsonObject;
    }

    //根据用户查询数据
    private final String WX_COUNT="WX_COUNT:";
    @PostMapping("/wuxing/count")
    public Integer queryCount(@RequestBody JSONObject jsonObject){
        log.info("{}",jsonObject);
        String user = jsonObject.get("userName").toString();
        String str = redisTemplate.opsForValue().get(WX_COUNT + user);
        if(!StringUtils.isEmpty(str)){
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
               return 0;
            }
        }
        return 0;
    }

    @PostMapping("/wuxing/update")
    public String updateCount(@RequestBody JSONObject jsonObject){
        Object userName = jsonObject.get("userName666");
        Object count = jsonObject.get("count888");
        if(null != userName && null != count){
            redisTemplate.opsForValue().set(WX_COUNT+userName.toString(), count.toString());
            return "ok";
        }else {
            return "error";
        }
    }

    @PostMapping("/wuxing/obtain")
    public void obtain(@RequestBody JSONObject jsonObject){
        redisTemplate.opsForValue().set(WX_COUNT+jsonObject.get("userName").toString(),"1800000000" );
    }

}
