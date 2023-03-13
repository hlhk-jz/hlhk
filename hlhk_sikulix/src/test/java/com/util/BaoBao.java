package com.util;

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
        try {
            SikJZB.gb(region);
            Match match = region.find("D:/software/sikulix/image/baobao6.PNG");
            while (null == match){
                SikJZB.gb(region);
                match = region.find("D:/software/sikulix/image/baobao6.PNG");
                Thread.sleep(500);
                if(null == match){
                    System.out.println("检测到宝宝不在线，召唤中！！！！！！");
                    match = region.wait("D:/software/sikulix/image/bbzh.PNG",1);
                    Thread.sleep(500);
                    if(null == match){
                        match = region.wait("D:/software/sikulix/image/bbzh.PNG",3);
                    }
                    Thread.sleep(500);
                    match.click();
                    match.setX(match.getX()-30);
                    match.hover();
                    match = region.wait("D:/software/sikulix/image/baobao6.PNG",5);
                    Thread.sleep(500);
                }
            }
            //检查宝宝血药
            SikYaoPin.bbYaoPin(region);
        }catch (Exception e){
            e.printStackTrace();
            baobao(region);
        }
    }
}
