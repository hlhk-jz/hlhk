package com.util;
import org.opencv.core.Mat;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.util.List;
import java.util.Map;

//打怪
public class SikDaGuai {

   /* public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        daGuai(region);
    }*/


    public static void daGuai(Region region )throws Exception{
        int count = 0;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        Match match = region.wait(CurrencyData.tldJZ,0.5);
        if(null == match){
            match = region.wait(CurrencyData.xsJZ,0.5);
        }
        //如果教主不为空一直循环打
        while (null != match){
            System.out.println("循环打怪count："+count);
            if(count > 222){
                break;
            }
            if((count%2)==0){
                match.setX(match.getX()+20);
            }else {
                match.setX(match.getX()-20);
            }
            match.rightClick();
            //关闭弹窗
            SikJZB.gb(region);
            //第一次，必须激活教主并且锁定成功
            if(0 == count){
                sdHj(region);
            }else {
                //锁定
                if((count % 5)==0){
                    sdHj(region);
                }
                //合击
                region.type(Key.F3);
                //检查装备
                if((count % 8)==0){
                    System.out.println("打怪期间检查装备~~~~");
                    SikJZB.pickup();
                    //关闭弹窗
                    SikJZB.gb(region);
                }
                //检查药品
                if((count % 30)==0){
                    System.out.println("打怪期间检查药品！！！！");
                    SikYaoPin.zhYaoPin(region);
                    SikYaoPin.bbYaoPin(region);
                    //关闭弹窗
                    SikJZB.gb(region);
                }
            }
            count++;
            match = region.wait(CurrencyData.tldJZ,2);
            //防止人物重叠怪识别不出来再次查询
            if(null == match){
                region.setX(0);
                region.setY(0);
                region.setW(1200);
                region.setH(800);
                Settings.MinSimilarity= 0.8;
                //关闭弹窗
                SikJZB.gb(region);
                Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",2);
                matchyd.setY(matchyd.getY()-377);
                matchyd.setX(matchyd.getX()+400);
                matchyd.rightClick();
                Settings.MinSimilarity= 0.7;
                region.type(Key.F4);
                match = region.wait(CurrencyData.tldJZ,2);
                if(null == match){
                    //跟随寻找教主
                    region.type(Key.F4);
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-377);
                    matchyd.rightClick();
                    match = region.wait(CurrencyData.tldJZ,2);
                    if(null == match){
                        region.type(Key.F1);
                        matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                        matchyd.setY(matchyd.getY()-150);
                        matchyd.setX(matchyd.getX()+180);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        region.type(Key.F4);
                        match = region.wait(CurrencyData.tldJZ,4);
                    }
                }
            }
        }
    }


    //锁定
    public static Match sdHj(Region region)throws Exception{
        System.out.println("锁定教主执行！！！！");
        Match match = null;
        Match sdMatch = null;
        int sdCount = 0;
        while (null == sdMatch){
            if(sdCount > 15){
                System.out.println("锁定执行大于15，结束循环！！！！");
                break;
            }
            //寻找教主
            match = region.wait(CurrencyData.tldJZ,2);
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
                        System.out.println("寻找锁定教主为空~~~~~~~");
                        break;
                    }
                }
            }

            if(sdCount != 0 && sdCount != 1){
                System.out.println("下移！！！！！！！");
                match.setY(match.getY()+80);
                match.hover();
                //锁定
                region.type(Key.F2);
                Thread.sleep(200);
                match.rightClick();
                for (int i=0;i<5;i++){
                    match = region.wait(CurrencyData.tldJZ,0.5);
                    if(null != match){
                        match.setY(match.getY()+80);
                        match.hover();
                        region.type(Key.F2);
                        Thread.sleep(200);
                        match.rightClick();
                    }
                }
            }
            //寻找英雄锁定
            sdMatch = region.wait(CurrencyData.ztsd,1);
            region.type(Key.F4);
            sdCount++;
        }
        return match;
    }
}
