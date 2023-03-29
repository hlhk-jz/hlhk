package com.util;
import com.google.common.collect.Lists;
import com.xinshou.XinShouHandler;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//回收装备
public class SikHS {
    /* public static void main(String[] args){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            hs(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void hs(Region region)throws Exception{
        Settings.MinSimilarity = 0.7;
        SikJZB.gb(region);
        Match match = region.wait("D:/software/sikulix/image/hs1.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs11.PNG",1);
            if(null == match){
                match = region.wait("D:/software/sikulix/image/hs4.PNG",1);
            }
        }
        match.click();
        Thread.sleep(500);
        region.type(Key.ENTER);
        Thread.sleep(500);
        region.type("@fuwu");
        Thread.sleep(500);
        region.type(Key.SPACE);
        Thread.sleep(500);
        match = region.wait("D:/software/sikulix/image/fuwu.PNG",0.8);
        if(null ==  match){
            region.type(Key.ENTER);
            region.type(Key.SHIFT);
            match = region.wait("D:/software/sikulix/image/hs1.PNG",1);
            if(null == match){
                match = region.wait("D:/software/sikulix/image/hs11.PNG",1);
                if(null == match){
                    match = region.wait("D:/software/sikulix/image/hs4.PNG",1);
                }
            }
            Thread.sleep(500);
            match.click();
            Thread.sleep(500);
            region.type(Key.ENTER);
            Thread.sleep(500);
            region.type("@fuwu");
            Thread.sleep(500);
            region.type(Key.SPACE);
            Thread.sleep(500);
        }
        region.type(Key.ENTER);
        //查找 回收装备 选项
        match = region.wait("D:/software/sikulix/image/hs2.PNG",2);
        match.click();
        Thread.sleep(500);
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        //如果没有回收问题，点击回收
        if(null != match){
            match.click();
        }else {
            region.setX(0);
            region.setY(0);
            region.setW(515);
            region.setH(302);
            pdty(region);
            region.setX(0);
            region.setY(0);
            region.setW(1200);
            region.setH(800);
        }
    }


    public static void pdty(Region region)throws Exception{
        Region ziReg = new Region(0,114,399,134);
        ziReg.setThrowException(false);
        Settings.MinSimilarity=0.85;
        Map<String,Object> map = CurrencyData.ZBenum.getMap(
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,
                41,42,43,44,45,46);
        Set<String> set = map.keySet();
        List<Object> keyList = new ArrayList<>(set);
        List<List<Object>> partition = Lists.partition(keyList, 6);
        Match match = null;
        boolean isTrue = true;
        for (List<Object> keys:partition){
            List<Match> anyList = region.findAnyList(keys);
            if(!anyList.isEmpty()){
                for (Object str : keys){
                    match = region.wait(str+"",1 );
                    if(null != match){
                        match = ziReg.wait(map.get(str+""),2);
                        if(null != match){
                            match.click();
                            isTrue = false;
                        }
                    }
                }
                break;
            }
        }


        //如果没有查到，刷新
        if(isTrue){
            //判断是否刷新过，如果刷新过就小退下
            String xiaoTui_key = RedisUtils.redisTemplate.opsForValue().get("xiaoTui_key");
            if(!StringUtils.isEmpty(xiaoTui_key) && "true".equals(xiaoTui_key)){
                RedisUtils.redisTemplate.opsForValue().set("xiaoTui_key","false");
                CurrencyData.xiaoTui(region);
                Thread.sleep(2000);
                //小退後重新回收
                hs(region);
            }

            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            if(null == match){
                System.out.println("未查询到刷新按钮！！！！！");
                hs(region);
            }
            match.click();
            RedisUtils.redisTemplate.opsForValue().set("xiaoTui_key","true");
            pdty(region);
        }

        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",2);
        }
        if(null == match){
            hs(region);
        }
        match.click();
    }
}
