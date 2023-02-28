package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.util.List;

//打怪
public class SikDaGuai {

/*    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        daGuai(region);
    }*/

    //道法
    public static void daGuai(Region region )throws Exception{
        int count = 0;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        Region bsdReg = new Region(139,609,728,264);
        bsdReg.setThrowException(false);
        Match match = region.wait(CurrencyData.tldJZ,0.5);
        if(null == match){
            match = region.wait(CurrencyData.xsJZ,0.5);
        }
        //如果教主不为空一直循环打
        while (null != match){
            //关闭弹窗
            SikJZB.gb(region);
            //第一次，必须激活教主并且锁定成功
            match.rightClick();
            if(0 == count){
                sdHj(region);
            }else {
                //锁定和施毒术无极真气
                if((count % 10)==0){
                    sdHj(region);
                }
                //检查装备
                if((count % 10)==0){
                    System.out.println("打怪期间检查装备~~~~");
                    SikJZB.pickup();
                    //关闭弹窗
                    SikJZB.gb(region);
                }
                //检查药品
                if((count % 20)==0){
                    System.out.println("打怪期间检查药品！！！！");
                    SikYaoPin.zhYaoPin(region);
                    SikYaoPin.bbYaoPin(region);
                    //关闭弹窗
                    SikJZB.gb(region);
                }
                //嗜血术
                /*Thread.sleep(500);
                region.type(Key.F7);
                Thread.sleep(800);*/
                //合击
                region.type(Key.F3);
            }
            count++;
            match = region.wait(CurrencyData.tldJZ,2);
            //防止人物重叠怪识别不出来再次查询
            if(null == match){
                //关闭弹窗
                SikJZB.gb(region);
                Thread.sleep(500);
                Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-377);
                matchyd.setX(matchyd.getX()+400);
                matchyd.rightClick();
                region.type(Key.F4);
                match = region.wait(CurrencyData.tldJZ,2);
                if(null == match){
                    //跟随寻找教主
                    region.type(Key.F4);
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-377);
                    matchyd.rightClick();
                    match = region.wait(CurrencyData.tldJZ,4);
                    if(null == match){
                        region.type(Key.F1);
                        matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                        matchyd.setY(matchyd.getY()-150);
                        matchyd.setX(matchyd.getX()+180);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        region.type(Key.F4);
                        match = region.wait(CurrencyData.tldJZ,3);
                    }
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

    //锁定施毒术 type = 0需要激活，1不需要
    public static Match sdHj(Region region)throws Exception{
        System.out.println("锁定施毒术执行！！！！");
        int xzCount = 1;
        int sdCount = 1;
        Match match = null;
        Match sdMatch = null;
        while (null == sdMatch){
            if(sdCount > 15){
                System.out.println("锁定施毒术执行大于15，结束循环！！！！");
                break;
            }
            //寻找教主
            match = region.wait(CurrencyData.tldJZ,5);
            if(null == match){
                Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-377);
                matchyd.setX(matchyd.getX()+400);
                matchyd.rightClick();
                match = region.wait(CurrencyData.tldJZ,1);
                if(null == match){
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-377);
                    matchyd.rightClick();
                    match = region.wait(CurrencyData.tldJZ,1);
                    if(null == match){
                        System.out.println("锁定施毒教主为空~~~~~~~");
                        break;
                    }
                }
            }
            if(xzCount!=5 && xzCount!=10){
                match.setY(match.getY()+80);
            }else {
                match.setX(match.getX()-20);
            }
            xzCount++;
            //锁定
            region.type(Key.F2);
            region.type(Key.F2);
            Thread.sleep(300);
            //右键激活教主
            match.rightClick();
            //寻找英雄锁定
            sdMatch = region.wait(CurrencyData.ztsd,0.5);
            sdCount++;
        }
        if(null != match){
            System.out.println("施毒执行。。。。。");
            //释放施毒术
            match = region.wait(CurrencyData.tldJZ,1);
            if(null != match){
                match.setY(match.getY()+80);
                region.type(Key.F6);
                Thread.sleep(1000);
                //释放施毒术
                region.type(Key.F6);
                Thread.sleep(1500);
                //查看是否被锁定
                bsd(region);
                //释放施毒术
                region.type(Key.F6);
                Thread.sleep(1500);
                //无极真气
                region.type(Key.F5);
            }
        }
        return match;
    }
}
