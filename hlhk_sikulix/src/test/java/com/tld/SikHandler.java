package com.tld;
import com.google.common.collect.Iterators;
import com.util.*;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SikHandler {
    private static long count = 0;

    public static void handler(Region region)throws Exception {
        CurrencyData.rhlmx();
        //判断是否在屠龙殿地图
        Thread.sleep(500);
        SuiJiShi.isTuLd(region);
        count ++;
        //5. 寻找随机石
        SuiJiShi.suiJiShi(region);
        Thread.sleep(1000);
        Match match2 = region.wait(CurrencyData.zblSjs,1);
        if(null == match2){
            match2 = region.wait(CurrencyData.zblSjs,1);
        }

        //6. 寻找教主
        List<Match> anyList = new ArrayList<>();
        Match yd = null;
        int n = 1;
        while (true){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(500);
            //寻找教主
            anyList = region.findAnyList(CurrencyData.jzList());
            Thread.sleep(1000);
            CurrencyData.isTrue(region,0 );
            if(anyList.isEmpty()){
                Match matchyd;
                yd = region.wait("D:/software/sikulix/image/youxia.PNG",0.3);
                if(null != yd){
                    //右下
                    matchyd= region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-100);
                    matchyd.setX(matchyd.getX()+400);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(300);
                    matchyd.rightClick();
                    Thread.sleep(300);
                    matchyd.rightClick();
                    Thread.sleep(300);
                    //寻找教主
                    anyList = region.findAnyList(CurrencyData.jzList());
                    Thread.sleep(1000);
                    if(anyList.isEmpty()){
                        //左上
                        matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                        matchyd.setY(matchyd.getY()-500);
                        matchyd.setX(matchyd.getX()-80);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        matchyd.rightClick();
                        Thread.sleep(300);
                        matchyd.rightClick();
                        Thread.sleep(300);
                    }
                }
            }
            //寻找教主
            anyList = region.findAnyList(CurrencyData.jzList());
            Thread.sleep(1000);
            //如果找到教主了推出循环
            if (!anyList.isEmpty()){
                break;
            }
            //查看是否在屠龙殿
            if((n%5)==0){
               SuiJiShi.isTuLd(region);
            }
            if(n > 40){
                //随机40次没有怪后，调用随机石方法
                System.out.println("随机石超过40检查包裹和药品");
                SuiJiShi.suiJiShi(region);
                //检查药品
                SikYaoPin.zhYaoPin(region);
                n = 1;
            }
            //寻找随机石，因为有可能随机石在其它位置了，所以在查一遍
            match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
            if(null == match2){
                match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",0.5);
            }
        }

        //7. 循环打怪直到没有怪为止,防止没打完，调用两次
        System.out.println("调用打怪开始！！！！！！");
        TldDaGuai.zdDaguai(region);
        System.out.println("调用打怪结束~~~~~~~~~~~");

        //8. 打完怪捡装备,防止漏捡，调用多次
        System.out.println("调用捡装备开始！！！！！！");
        SikJZB.pickup();
        region.type(Key.F1);
        System.out.println("调用捡装备结束！！！！！！");
        //9. 回收
        match2 = region.wait("D:/software/sikulix/image/baoguo.PNG",1);
        match2.click();
        Iterator<Match> all = CurrencyData.kgRegion.findAll("D:/software/sikulix/xinshou/kg.PNG");
        if(null == all || Iterators.size(all)<=4){
            System.out.println("回收装备开始~~~");
            SikHS.hs(region);
            System.out.println("回收装备结束~~~");
        }
        //10. 检查药品,主号和宝宝
        if((count%8)==0){
            //火龙之心
            System.out.println("检查宝宝火龙之心修复装备开始！时间："+System.currentTimeMillis()/1000);
            HLZX.hlzx(region);
            System.out.println("火龙之心检查装备结束！时间："+System.currentTimeMillis()/1000);
            //检查磨血石，如果有人龙印只修装备就可以
            System.out.println("检查魔血石开始！！！！");
            MoXueShi.jcMXS(region);
            System.out.println("检查魔血石结束~~~~~~");
            //修复装备
            System.out.println("修复装备开始！！！！");
            XiuFuZB.xfzb(region);
            System.out.println("修复装备结束~~~~~~");
        }
        //12. 循环地柜
        System.out.println("~~~~~~~~~~~本次超级循环数量："+count);
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(800);
        Settings.MinSimilarity= 0.7;
        handler(region);
    }
}
