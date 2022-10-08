package cn.test;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class Test4 {
    public static void main(String[] args)throws Exception{

        String sd = second2Time(400L);
        log.info("====== "+sd);


      /*  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Long sTime = simpleDateFormat.parse("20220719140505").getTime();
        Long eTime = simpleDateFormat.parse("20220719145816").getTime();
        String s = secondTime((eTime - sTime) / 1000);

        log.info("============ "+s);*/

      /*  String str = "市气象台2022年6月22日16时30分发布高温黄色预警信号：预计23日至25日，本市大部分地区日最高气温将达35℃以上，请注意防范。（预警信息来源：国家预警信息发布中心）";


        String strd = str.split("：")[1].split("。")[0];
        log.info("============ "+strd);*/




 /*       String s1 = second2Time(500000L);
        String[] split = s1.split(":");
        String str = "已停";
        if(split.length == 1){
            str = str+ split[0]+"秒";
        }
        if(split.length == 2){
            str = str + split[0]+"分钟";
        }
        if(split.length == 3){
            str = str + split[0]+"小时"+split[1]+"分钟";
        }

        String sd = "";
        log.info("========= "+sd.length());*/

     /*   Stu stu = new Stu();
        stu.setName("4444444444444");
        Map<String,Stu> map = new HashMap<>();
        map.put("1",stu);
        log.info("=========== "+map);
        Stu stu1 = map.get("1");
        stu1.setName("张三");
        log.info("3333333333");
        log.info("........... "+map);*/
    }
    public static String secondTime(Long second) {
        String req = "";
        if (second == null || second < 0) {
            return "";
        }
        long h = second / 3600;
        long m = (second % 3600) / 60;
        long s = second % 60;
        String str = "";
        if (h > 0) {
            str = (h < 10 ? ("0" + h) : h) + ":";
        }
        str += (m < 10 ? ("0" + m) : m) + ":";
        str += (s < 10 ? ("0" + s) : s);
        return str;
    }

    public static String second2Time(Long second) {
        String req = "";
        if (second == null || second < 0) {
            return "";
        }
        long h = second / 3600;
        long m = (second % 3600) / 60;
        long s = second % 60;
        String str = "";
        if (h > 0) {
            str = (h < 10 ? ("0" + h) : h) + ":";
        }
        if(m > 0){
            str += (m < 10 ? ("0" + m) : m) + ":";
        }
        str += (s < 10 ? ("0" + s) : s);
        String[] split = str.split(":");
        if(split.length == 1){
            req = req+ split[0]+"秒";
        }
        if(split.length == 2){
            req = req + split[0]+"分钟";
        }
        if(split.length == 3){
            req = req + split[0]+"小时"+split[1]+"分钟";
        }
        return req;
    }
}
