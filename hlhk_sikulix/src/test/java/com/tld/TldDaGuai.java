package com.tld;
import com.util.*;
import org.opencv.core.Mat;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.util.List;
import java.util.Map;

//屠龙殿打怪
public class TldDaGuai {

    public static void main(String[] args) throws Exception {
        Region region = new Region(0, 0, 1920, 1080);
        region.setThrowException(false);
        zdDaguai(region);
    }

    public static void zdDaguai(Region region) throws Exception {
        int count = 0;
        int hlCount = 1;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        //查看主号药品
        region.type(Key.F1);
        Match match = region.wait(CurrencyData.tldJZ, 1);
        while (null != match){
            match.setY(match.getY()+80);
            match.click();
            Thread.sleep(500);
            //释放合击
            SikJZB.gb();
            region.type(Key.F3);
            Settings.MinSimilarity = 0.99;
            Thread.sleep(800);
            //查看是否释放成功
            Match cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 1);
            if(null != cgMatch){
                //再次判断合击
                cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 12);
                if(null != cgMatch){
                    region.type(Key.F3);
                    Thread.sleep(800);
                    cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 1);
                    if(null != cgMatch){
                        System.out.println("释放合击成功~~~~~");
                        while (true){
                            //判断是否锁定
                            CurrencyData.isTrue();
                            BaoBao.baobao(region);
                            Settings.MinSimilarity = 0.99;
                            //查看合击是否满了
                            cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 1);
                            if(null != cgMatch){
                                //释放合击
                                Thread.sleep(800);
                                region.type(Key.F3);
                                Thread.sleep(300);
                                cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 2);
                                if(null == cgMatch){
                                    System.out.println("当前怪打完，查找下一个！！！");
                                    //捡装备
                                    SikJZB.pickup();
                                    region.type(Key.F1);
                                    SikYaoPin.zhYaoPin(region);
                                    Thread.sleep(1500);
                                    count = 1;
                                    break;
                                }
                                SikYaoPin.zhYaoPin(region);
                            }
                            if(hlCount > 50){
                                //防止没有火龙之心
                                System.out.println("打怪期间检查到宝宝没有火龙之心！！！！！！！！！！！！！！");
                                Settings.MinSimilarity = 0.7;
                                Thread.sleep(500);
                                HLZX.hlzx(region);
                                Settings.MinSimilarity = 0.99;
                                Thread.sleep(500);
                            }
                            hlCount ++;
                        }
                        hlCount = 1;
                    }
                }
            }
            count++;
            Settings.MinSimilarity = 0.7;
            //判断是否锁定
            CurrencyData.isTrue();
            if (count > 3) {
                System.out.println("打怪大于指定次数结束本次循环！！！！！！");
                break;
            }else {
                match = CurrencyData.xszgRegion.wait(CurrencyData.tldJZ, 2);
                if(null == match){
                    match= region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    if(null != match){
                        match.setY(match.getY()-80);
                        match.rightClick();
                        Thread.sleep(300);
                        match.rightClick();
                        region.type(Key.F4);
                        match = CurrencyData.xszgRegion.wait(CurrencyData.tldJZ, 1);
                    }
                }
                region.type(Key.F1);
            }
        }
    }
}

