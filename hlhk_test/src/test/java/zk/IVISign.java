package zk;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpConfig;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
//车机-ZK 签名
@Slf4j
public class IVISign {
    public static void main(String[] args)throws Exception{
        String accessId = "CS22222222";
        String accessKey = Sm3Util.sm3bcHex(accessId.getBytes());
        String transId = RandomUtil.randomNumbers(32);
        String timestamp =  System.currentTimeMillis()/1000+"";

        //String body = "{\"phone\":\"13841374336\"}";
        //String body = "{\"carNum\":\"辽AA633G\",\"vin\":\"CS22222222\",\"phone\":\"13841374336\",\"verCode\":\"212765\"}";
        //String body = "{\"vin\":\"CS22222222\"}";
        //String body = "{\"vin\":\"CS22222222\",\"tpms\":\"1\",\"updateTime\":\"2024-04-25 13:53:50\"}";
        String body = "{\"vin\":\"CS22222222\",\"iccid\":\"89861123200090282671\"}";
        JSONObject jb = JSONObject.parseObject(body);
        body = JSON.toJSONString(jb, SerializerFeature.MapSortField);
        String str = accessId+transId+timestamp+body;
        String content = new Digester(DigestAlgorithm.SHA512).digestHex(str);
        //签名
        String sign = SecureUtil.hmacSha1(accessKey).digestBase64(content, false);
        log.info("accessId:{} ,transId:{} ,timestamp:{} ,sign:{} ",accessId,transId,timestamp,sign );
/*
        HttpRequest post = HttpUtil.createPost("http://192.168.31.202:9010/dbt-ivi/ivi/data");
        HttpResponse execute = post.header("accessId", accessId)
                .header("transId", transId)
                .header("timestamp", timestamp)
                .header("sign", sign)
                .body(body)
                .execute();
        log.info("req:{}", execute);*/
    }
}
