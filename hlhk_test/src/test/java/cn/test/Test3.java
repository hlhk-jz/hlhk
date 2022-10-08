package cn.test;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class Test3 {
    public static void main(String[] args)throws Exception{
       /* String str = "2022-04-01";
        String substring = str.substring(5, 7);
        log.info("sbu = "+Integer.parseInt(substring));*/
       /* String str = "2021-03";
        String str1 = "2022-01";
        Integer replace = Integer.parseInt(str.replace("-", ""));
        Integer replace1 = Integer.parseInt(str1.replace("-", ""));



        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        df.setTimeZone(TimeZone.getTimeZone("GMT+08"));// 这里一定要设置GMT时区
        Date sDate = df.parse(str);
        Date eDate = df.parse(str1);
        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sDate);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(eDate);
        long timeInMillis2 = calendar.getTimeInMillis();

        long sd = (timeInMillis2-timeInMillis1) /1000/60/60/24;
        log.info("========= "+sd);*/
        Calendar calendar = Calendar.getInstance();
       /* Long time = calendar.getTime().getTime()/1000;
        log.info("时间：{}",time);
        log.info("当前时间：{}",System.currentTimeMillis()/1000);*/
        int i = calendar.get(Calendar.YEAR);
        int i1 = calendar.get(Calendar.MONTH);
        log.info("年：{}，月：{}",i,i1);

    }
}
