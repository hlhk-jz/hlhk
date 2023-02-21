package com;
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
    public static void daGuai(Region region ){
        int count = 0;
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
            Region bsdReg = new Region(139,609,728,264);
            bsdReg.setThrowException(false);
            Match sdMatch = null;
            Match match = region.wait(CurrencyData.tldJZ,0.5);
            if(null == match){
                match = region.wait(CurrencyData.xsJZ,0.5);
            }
            System.out.println("打怪查询："+match);
            //如果教主不为空一直循环打
            while (null != match){
                //第一次，必须激活教主并且锁定成功
                if(0 == count){
                    while (null == sdMatch){
                        //如果找不到教主了一直寻找
                        match = region.wait(CurrencyData.tldJZ,0.5);
                        while (null == match){
                            match = region.wait(CurrencyData.tldJZ,0.5);
                        }
                        match.setY(match.getY()+80);
                        match.hover();
                        //锁定
                        region.type(Key.F2);
                        //右键激活教主
                        match.rightClick();
                        //寻找英雄锁定
                        sdMatch = region.wait(CurrencyData.ztsd,0.5);
                    }
                }else {
                    //左键鼠标悬浮
                    match.setY(match.getY()+80);
                    match.hover();
                    //施毒术
                    if((count % 6)==0 || count == 1){
                        //释放施毒术
                        region.type(Key.CTRL+Key.F4);
                        Thread.sleep(2000);
                        //查看是否被锁定
                        bsd(bsdReg);
                        //释放施毒术
                        region.type(Key.CTRL+Key.F4);
                        Thread.sleep(2000);
                        //查看是否被锁定
                        bsd(bsdReg);
                    }
                    //锁定
                    region.type(Key.F2);
                    //嗜血术
                    region.type(Key.F6);
                    //检查药品捡装备
                    if((count % 20)==0){
                        System.out.println("打怪期间检查药品和捡装备");
                        region.type(Key.F12);
                        SikJZB.pickup();
                        SikYaoPin.zhYaoPin(region);
                        SikYaoPin.bbYaoPin(region);
                        //检查关闭
                        try {
                            List<Match> anyList = region.findAnyList(CurrencyData.gbList());
                            Thread.sleep(1000);
                            if(!anyList.isEmpty()){
                                for (Match gbms:anyList){
                                    gbms.click();
                                    Thread.sleep(500);
                                }
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    //合击
                    region.type(Key.F3);
                    //查看是否被锁定
                    bsd(bsdReg);
                    //右键跟随教主
                    if((count % 2)==0){
                        match.setY(match.getY()+100);
                        match.rightClick();
                    }else {
                        match.setY(match.getY()-100);
                        match.rightClick();
                    }

                    match = region.wait(CurrencyData.tldJZ,8);
                }
                count++;
            }

        }catch (Exception e){
            //报异常后，重复调用下
            try {
                Thread.sleep(3000);
                e.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            count = 0;
            daGuai(region);
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
}
