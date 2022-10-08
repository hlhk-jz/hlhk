package com;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
@Slf4j
public class Test {
    static String accessKey  =  "fe0a344b4fb686f429675fafab73f39c";
    //客户端准入Id	由蓁康线下提供
    static String accessId = "ZZXT";
    public static void main(String[] args){
        //流水号客户端自己生成
        String transId = (UUID.randomUUID()+"").replace("-","" );
        //时间戳
        Long timestamp = System.currentTimeMillis();
        //数据
        Map<String,Object> map = new TreeMap<>();
        map.put("sn",System.currentTimeMillis()/1000 +"" );
        map.put("supplierId", System.currentTimeMillis()/1000 +"");
   /*     JSONObject jsonObject = new JSONObject();
        jsonObject.put("sn",System.currentTimeMillis()/1000 +"" );
        jsonObject.put("supplierId", System.currentTimeMillis()/1000 +"");*/

        //签名
        String sign = get(transId,timestamp,map);

        log.info("============ "+sign );

        String body = HttpRequest.post("101.42.175.131:9010/dbt-ivi-sync/mes/sync/ivi/add")
                .header("accessId", accessId)
                .header("transId", transId)
                .header("timestamp", timestamp + "")
                .header("sign", sign)
                .body(JSON.toJSONString(map))
                .execute().body();

        log.info("======== "+body);
    }

    private static String get(String transId, Long timestamp,Map<String,Object> map ) {
        String signature = null;
        try {
            String s1 = JSON.toJSONString(map);
            String str = accessId + transId+ timestamp + s1;
            String content = new Digester(DigestAlgorithm.SHA512).digestHex(str);
             signature = SecureUtil.hmacSha1(accessKey).digestBase64(content, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }
}
