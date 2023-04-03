package com.xinshou;
import com.google.common.collect.Lists;
import com.util.CurrencyData;
import com.util.RedisUtils;
import com.util.SikJZB;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//新手回收，没有回收权限回土城
public class XinShouHS {
       public static void main(String[] args){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            Match match = region.wait("D:/software/sikulix/xinshou/hszb.PNG",1);
            match.click();
            xshs(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xshs(Region region)throws Exception{
        SikJZB.gb();
        Match match = region.wait("D:/software/sikulix/image/hs5.PNG",2);
        //如果没有回收问题，点击回收
        if(null != match){
            match.click();
            match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
            if(null == match){
                if(null == match){
                    XinShouHandler.tcHuiShou(region);
                }
            }
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
        //问题解答查询的对象
        Region ziReg = new Region(0,114,399,134);
        ziReg.setThrowException(false);
        Settings.MinSimilarity=0.85;
        Match match = null;
        boolean isTrue = true;
        Map<String,Object> map = CurrencyData.ZBenum.getMap(
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,
                31,32,33,34,35,36,37,38,39,40,
                41,42,43,44,45,46);
        Set<String> set = map.keySet();
        List<Object> keyList = new ArrayList<>(set);
        List<List<Object>> partition = Lists.partition(keyList, 6);
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
                XinShouHandler.tcHuiShou(region);
            }

            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            if(null == match){
                System.out.println("未查询到刷新按钮！！！！！");
                XinShouHandler.tcHuiShou(region);
            }
            match.click();
            RedisUtils.redisTemplate.opsForValue().set("xiaoTui_key","true");
            pdty(region);
        }

        match = region.wait("D:/software/sikulix/image/hs6.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs6.PNG",3);
        }
        if(null == match){
            XinShouHandler.tcHuiShou(region);
        }
        match.click();
        match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        if(null == match){
            match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        }
        if(null == match){
            XinShouHandler.tcHuiShou(region);
        }
        match.click();

        String xiaoTui_key = RedisUtils.redisTemplate.opsForValue().get("xiaoTui_key");
        if(!StringUtils.isEmpty(xiaoTui_key) && "true".equals(xiaoTui_key)){
            RedisUtils.redisTemplate.opsForValue().set("xiaoTui_key","false");
            CurrencyData.xiaoTui();
            Thread.sleep(2000);
        }
    }
}
