package zk;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
//车机-ZK 签名
@Slf4j
public class IVISign {
    public static void main(String[] args)throws Exception{
        String accessId = "LV3MD7253D1001005";
        String accessKey = Sm3Util.sm3bcHex(accessId.getBytes());
        String transId = RandomUtil.randomNumbers(32);
        String timestamp =  System.currentTimeMillis()/1000+"";

        String body = "{'address':'北京'}";
        JSONObject jb = JSONObject.parseObject(body);
        body = JSON.toJSONString(jb, SerializerFeature.MapSortField);
        String str = accessId+transId+timestamp+body;
        String content = new Digester(DigestAlgorithm.SHA512).digestHex(str);
        //签名
        String sign = SecureUtil.hmacSha1(accessKey).digestBase64(content, false);
        log.info("accessId:{} ,transId:{} ,timestamp:{} ,sign:{} ",accessId,transId,timestamp,sign );
    }
}
