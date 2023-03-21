package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
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
        Map<String,Object> map = CurrencyData.ZBenum.getMap(1,2,3);
        Set<String> set = map.keySet();
        Match match = null;
        boolean isTrue = true;
        for (String str : set){
            match = region.wait(str,1 );
            if(null != match){
                match = ziReg.wait(map.get(str),2);
                if(null != match){
                    match.click();
                    isTrue = false;
                    break;
                }
            }
        }
        //如果没有查到，刷新
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
    }
}
