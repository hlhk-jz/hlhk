package com.config;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pojo.EcallFirstPojo;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

//ecall 一次备案
@Slf4j
public class HttpFirstRecordUtil {
    public static int firstRecord(String vin,String vehiclePhone){
        int code = 200;
        String url = "http://192.168.31.124:9010/dbt-call/ecall/healthlink/firstRecord";
        String accessId = "LYKJ";
        String accessKey = "8c376bb1ea064776827dad47bf7692df";
        String transId = RandomUtil.randomNumbers(32);
        String timestamp =  System.currentTimeMillis()+"";
        EcallFirstPojo pojo = new EcallFirstPojo();
        pojo.setVin(vin);
        pojo.setVehicalPhone(vehiclePhone);
        pojo.setServiceStartdate(getDate(true));
        pojo.setServiceStopdate(getDate(false));
        //一次备案body
        String body = JSON.toJSONString(pojo, SerializerFeature.MapSortField);
        String str = accessId+transId+timestamp+body;
        String content = new Digester(DigestAlgorithm.SHA512).digestHex(str);
        String sign = SecureUtil.hmacSha1(accessKey).digestBase64(content, false);
        //log.info("accessId:{} ,transId:{} ,timestamp:{} ,sign:{} ",accessId,transId,timestamp,sign );
        String rspDate = HttpRequest.post(url)
                .header("accessId", accessId)
                .header("transId", transId)
                .header("timestamp", timestamp + "")
                .header("sign", sign)
                .body(body)
                .execute().body();
        String rsCode = JSONObject.parseObject(rspDate).get("code").toString();
        if(!rsCode.equals("000000")){
            code = 500;
        }
        return code;
    }

    public static String getDate(boolean type){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "";
        Calendar instance = Calendar.getInstance();
        if(type){
            //当天
            date = LocalDate.now()+" 23:59:59";
        }else {
            //一年后
            instance.set(Calendar.YEAR, instance.get(Calendar.YEAR)+1);
            date = format.format(instance.getTime());
        }
        return date;
    }
}
