package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.util.List;

//打怪
public class SikDaGuai {

   /* public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        daGuai(region);
    }*/

    //道法
    public static void daGuai(Region region )throws Exception{
        int count = 0;
        int xzCount = 0;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        Region bsdReg = new Region(139,609,728,264);
        bsdReg.setThrowException(false);
        Match match = region.wait(CurrencyData.tldJZ,0.5);
        if(null == match){
            match = region.wait(CurrencyData.xsJZ,0.5);
        }
        System.out.println("打怪查询："+match);
        //如果教主不为空一直循环打
        while (null != match){
            //第一次，必须激活教主并且锁定成功
            if(0 == count){
                sdHj(region);
            }else {
                //锁定和施毒术无极真气
                if((count % 7)==0){
                    sdHj(region);
                }
                //嗜血术
                region.type(Key.F7);
                //检查药品捡装备
                if((count % 20)==0){
                    System.out.println("打怪期间检查药品和捡装备");
                    region.type(Key.F12);
                    SikJZB.pickup();
                    SikYaoPin.zhYaoPin(region);
                    SikYaoPin.bbYaoPin(region);
                    //检查关闭
                    List<Match> anyList = region.findAnyList(CurrencyData.gbList());
                    Thread.sleep(1000);
                    if(!anyList.isEmpty()){
                        for (Match gbms:anyList){
                            gbms.click();
                            Thread.sleep(500);
                        }
                    }
                }
                //合击
                region.type(Key.F3);
                //查看是否被锁定
                bsd(region);
                //右键跟随教主
                if((count % 2)==0){
                    match.setX(match.getX()+30);
                    match.rightClick();
                }else {
                    match.setX(match.getX()-30);
                    match.rightClick();
                }
            }
            count++;
            match = region.wait(CurrencyData.tldJZ,3);
            //防止人物重叠怪识别不出来再次查询
            if(null == match){
                Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-377);
                matchyd.setX(matchyd.getX()+400);
                matchyd.rightClick();
                //如果找不到教主了一直寻找
                match = region.wait(CurrencyData.tldJZ,1);
                if(null == match){
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-377);
                    matchyd.rightClick();
                    match = region.wait(CurrencyData.tldJZ,1);
                }
            }
        }
    }


    private static void bsd(Region region) {
        Settings.MinSimilarity=0.85;
        try {
            Match match = region.find(CurrencyData.bsd);
            if(null != match){
                System.out.println("被锁定！！！！！！");
                Match match2 = region.wait("D:/software/sikulix/image/shitou.PNG",0.5);
                if(null == match2){
                    match2 = region.wait("D:/software/sikulix/image/shitou.PNG",1);
                }
                match2.doubleClick();
                Thread.sleep(300);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Settings.MinSimilarity=0.7;
    }

    //锁定施毒术
    public static void sdHj(Region region)throws Exception{
        int xzCount = 0;
        Match match = null;
        Match sdMatch = null;
        while (null == sdMatch){
            //寻找教主
            match = region.wait(CurrencyData.tldJZ,5);
            if(null == match){
                Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-377);
                matchyd.setX(matchyd.getX()+400);
                matchyd.rightClick();
                //如果找不到教主了一直寻找
                match = region.wait(CurrencyData.tldJZ,1);
                if(null == match){
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-377);
                    matchyd.rightClick();
                    match = region.wait(CurrencyData.tldJZ,1);
                    if(null == match){
                        TuiChu.tuiChu(region);
                    }
                }
            }
            if((xzCount%2)==0){
                match.setY(match.getY()-30);
            }else {
                match.setY(match.getY()+80);
            }
            xzCount++;
            match.hover();
            //锁定
            region.type(Key.F2);
            //右键激活教主
            match.rightClick();
            //寻找英雄锁定
            sdMatch = region.wait(CurrencyData.ztsd,0.5);
        }
        //释放施毒术
        region.type(Key.F6);
        Thread.sleep(2000);
        //查看是否被锁定
        bsd(region);
        //释放施毒术
        region.type(Key.F6);
        Thread.sleep(2000);
        //查看是否被锁定
        bsd(region);
        //释放施毒术
        region.type(Key.F6);
        Thread.sleep(2000);
        //无极真气
        region.type(Key.F5);
    }
}
