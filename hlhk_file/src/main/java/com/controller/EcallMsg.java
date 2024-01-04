package com.controller;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pojo.Ecall;
import com.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class EcallMsg {

    //查看车机电话
    public final String URL = "http://192.168.31.202:30042/dbt-call/ecall/healthlink/partNum";
    //一次备案
    public final String FIRST_URL = "http://192.168.31.202:30042/dbt-call/ecall/healthlink/firstRecord";
    //二次备案
    public final String TWE_URL = "http://192.168.31.202:30042/dbt-call/ecall/healthlink/secondRecord";

    @PostMapping("/importExcel")
    public Object importExcel(@RequestParam("file")MultipartFile file) {
        StringBuilder str = new StringBuilder();
        try {
            InputStream inputStream = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            List<Ecall> ecalls = reader.readAll(Ecall.class);

            Map<String,Object> body = new HashMap<>();
            if(!ecalls.isEmpty() && 0 != ecalls.size()){
                for (Ecall ecall : ecalls){
                    if(!StringUtils.isEmpty(ecall.getIccid()) && !StringUtils.isEmpty(ecall.getVin())){

                        //查询车机电话
                        body.put("iccid",ecall.getIccid() );
                        String phoneBody = HttpUtil.post(URL, JSON.toJSONString(body));
                        if(!StringUtils.isEmpty(phoneBody)  && (JSONObject.parseObject(phoneBody).get("code")+"").equals("000000")
                        && null != JSONObject.parseObject(phoneBody).get("data")){
                            String phone = JSONObject.parseObject(phoneBody).get("data").toString();
                            //一次备案
                            body.put("vin",ecall.getVin() );
                            body.put("serviceStartdate", "2024-01-1 12:33:22");
                            body.put("serviceStopdate", "2025-01-1 12:33:22");
                            body.put("vehicalPhone",phone );
                            phoneBody = HttpUtil.post(FIRST_URL, JSON.toJSONString(body));
                            if(!StringUtils.isEmpty(phoneBody)  && (JSONObject.parseObject(phoneBody).get("code")+"").equals("000000")){
                                //二次备案
                                String name = "测试"+RandomUtil.randomLong(1, 100);
                                body.put("name", name);
                                body.put("phone",phone );
                                User user = new User(name,phone);
                                List<User> list = new ArrayList<>();
                                list.add(user);
                                body.put("memberEmergencyContact",list );
                                phoneBody = HttpUtil.post(TWE_URL, JSON.toJSONString(body));
                                if(StringUtils.isEmpty(phoneBody)  || !(JSONObject.parseObject(phoneBody).get("code")+"").equals("000000")){
                                    str.append(ecall.getIccid()+",");
                                }
                            }else {
                                str.append(ecall.getIccid()+",");
                            }
                        }
                    }
                }
                if(!StringUtils.isEmpty(str+"")){
                    log.info("错误ICCID：{}",str.toString() );
                    return "错误ICCID："+str.toString();
                }
            }
        }catch (Exception e){
            log.error("{}",e );
        }
        return "OK";
    }

}
