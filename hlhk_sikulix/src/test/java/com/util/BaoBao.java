package com.util;

import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//检查宝宝是否挂了
public class BaoBao {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        baobao(region);
    }

    public static void baobao(Region region){
        System.out.println("检测宝宝是否在线！！！！");
        Settings.MinSimilarity = 0.7;
        try {
            SikJZB.gb(region);
            Match match = region.find("D:/software/sikulix/image/baobao6.PNG");
            while (null == match){
                SikJZB.gb(region);
                match = region.find("D:/software/sikulix/image/baobao6.PNG");
                Thread.sleep(500);
                if(null == match){
                    System.out.println("检测到宝宝不在线，召唤中！！！！！！");
                    match = CurrencyData.bbzhRegion.wait("D:/software/sikulix/image/bbzh.PNG",1);
                    Thread.sleep(500);
                    if(null == match){
                        match = CurrencyData.bbzhRegion.wait("D:/software/sikulix/image/bbzh.PNG",3);
                    }
                    Thread.sleep(500);
                    match.click();
                    match.setX(match.getX()-30);
                    Thread.sleep(300);
                    match.hover();
                    Thread.sleep(300);
                    match = region.wait("D:/software/sikulix/image/baobao6.PNG",5);
                    Thread.sleep(500);
                }
                if(null != match){
                    //检查宝宝血药
                    SikYaoPin.bbYaoPin(region);
                }
                CurrencyData.isTrue(region,0);
            }
        }catch (Exception e){
            e.printStackTrace();
            CurrencyData.isTrue(region,1 );
            baobao(region);
        }
    }
}
