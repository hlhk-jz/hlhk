package zk;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//三方-ZK 签名
public class WAISign {
    public static void main(String[] args)throws Exception{
        String accessId = "LYKJ";
        String accessKey = "8c376bb1ea064776827dad47bf7692df";
        //流水号客户端生成
        String transId = "4611417456690e729d7bbc3ccc4b0697";
        String timestamp =  System.currentTimeMillis()/1000+"";
        //String body = "{'vin':'QWERTYUIOLCH11111','accidentTriggerTime':'2022-11-04 11:10:22','accidentGpstype':'01','accidentGps':'123.437823,41.825102','accidentTriggerType':'01','alertPhone':'13222222222','beforeGps':[{'altitude':'12','date':'2022-11-04 11:09:22','latitude':'41.825102','longitude':'123.437823'}]}";
        //String body = "{\"accidentCourseAnalysis\":\"39° 59′ 24.71″ N116° 27′ 20.28″ E,267°\",\"accidentDamagedPlace\":0,\"accidentGps\":\"108.99705, 34.25005\",\"accidentGpstype\":\"01\",\"accidentImpactStrength\":\"1\",\"accidentTriggerTime\":\"2022-11-21 16:24:20\",\"accidentTriggerType\":\"01\",\"airbagStatus\":{\"firstPassengerDriverCurtainAirbag\":\"0\",\"firstRowDriveFrontAirbag\":\"1\",\"firstRowDriveSideAirbag\":\"0\",\"firstRowDriverCurtainAirbag\":\"0\",\"firstRowPassengerFrontAirbag\":\"0\",\"firstRowPassengerSideAirbag\":\"0\",\"secondRowDriveSideAirbag\":\"0\",\"secondRowPassengerSideAirbag\":\"0\",\"thirdRowDriveSideAirbag\":\"0\",\"thirdRowPassengerSideAirbag\":\"0\"},\"balloonNo\":1,\"beforeGps\":[{\"altitude\":\"1.0\",\"date\":\"2022-11-21:16:20:20\",\"latitude\":\"21.1212\",\"longitude\":\"123.123\"},{\"altitude\":\"1.0\",\"date\":\"2022-11-21:16:20:20\",\"latitude\":\"21.1212\",\"longitude\":\"123.123\"}],\"isBalloonNo\":\"是\",\"lastGps\":[{\"altitude\":\"1.0\",\"date\":\"2022-11-21:16:20:20\",\"latitude\":\"21.1212\",\"longitude\":\"123.123\"},{\"altitude\":\"1.0\",\"date\":\"2022-11-21:16:20:20\",\"latitude\":\"21.1212\",\"longitude\":\"123.123\"}],\"vin\":\"QWERTYUIOLCH11111\"}";
        String body = "{\"vin\":\"LVHDH3623SW000040\",\"serviceStartdate\":\"2023-03-10 12:33:22\",\"serviceStopdate\":\"2024-09-20 12:33:22\",\"vehicalPhone\":\"1410900004842\"}";
        JSONObject jb = JSONObject.parseObject(body);
        body = JSON.toJSONString(jb, SerializerFeature.MapSortField);
        String str = accessId+transId+timestamp+body;
        String content = new Digester(DigestAlgorithm.SHA512).digestHex(str);
        //签名
        String sign = SecureUtil.hmacSha1(accessKey).digestBase64(content, false);
        log.info("accessId:{} ,transId:{} ,timestamp:{} ,sign:{} ",accessId,transId,timestamp,sign );
    }
}
