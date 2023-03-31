package com;
import com.util.CurrencyData;
import com.util.RedisUtils;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

//监听
public class MonitorStart {
    public static void main(String[] args){
        //左上宝宝血量位置区域
        Region region = new Region(0, 0,1000,1000);
        region.setThrowException(false);
        while (true){
            try {
                //检查是否需要小退
                sw(region);
                //检查宝宝血量
                bbxl(region);
                //检查是否被锁定
                bsd(region);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sw(Region region)throws Exception{
        Settings.MinSimilarity= 0.99;
        region.setX(0);
        region.setY(502);
        region.setW(317);
        region.setH(373);
        Match match = region.wait("D:/software/sikulix/image/sw.PNG", 1);
        if(null != match){
            //防止上线后血量没加上来，睡眠一会在次判断
            Thread.sleep(5000);
            //人物需要小退
            match = region.wait("D:/software/sikulix/image/sw.PNG", 1);
            if(null != match){
                System.out.println("检测到人物需要小退！！当前时间："+System.currentTimeMillis()/1000);
                //存储redis判断条件
                RedisUtils.redisTemplate.opsForValue().set(CurrencyData.SWKEY,"true",60, TimeUnit.SECONDS);
            }
        }
    }

    public static void bbxl(Region region)throws Exception{
        Match match = null;
        Settings.MinSimilarity= 0.95;
        region.setX(1);
        region.setY(0);
        region.setW(211);
        region.setH(60);
        match = region.wait("D:/software/sikulix/image/xl.PNG",1);
        if(null != match){
            if(StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(CurrencyData.SDKEY))){
                System.out.println("宝宝血量减少！！！当前时间："+System.currentTimeMillis());
                region.type(Key.F5 );
                Thread.sleep(300);
                region.type(Key.F5 );
                Thread.sleep(300);
                region.type(Key.F5 );
                RedisUtils.redisTemplate.opsForValue().set(CurrencyData.SDKEY,"true",60, TimeUnit.SECONDS);
                Thread.sleep(1000);
            }
        }
    }

    private static void bsd(Region region)throws Exception {
        Settings.MinSimilarity=0.85;
        region.setX(133);
        region.setY(438);
        region.setW(690);
        region.setH(391);
        Match match = region.wait(CurrencyData.bsd,1);
        if(null != match){
            if(StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(CurrencyData.SDKEY))){
                System.out.println("被锁定！！！当前时间："+System.currentTimeMillis()/1000);
                region.type(Key.F5 );
                Thread.sleep(300);
                region.type(Key.F5 );
                Thread.sleep(300);
                region.type(Key.F5 );
                RedisUtils.redisTemplate.opsForValue().set(CurrencyData.SDKEY,"true",60, TimeUnit.SECONDS);
                Thread.sleep(1000);
            }
        }
    }
}
