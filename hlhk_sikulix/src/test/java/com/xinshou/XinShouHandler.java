package com.xinshou;

import com.google.common.collect.Iterators;
import com.tld.ATuLongDianStart;
import com.util.*;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XinShouHandler {
    private static long count = 1;
    public static void handler(Region region)throws Exception {
        //判断是否在新手地图
        Thread.sleep(300);
        SuiJiShi.isXinShou(region);
        count ++;
        //5. 寻找随机石
        SuiJiShi.suiJiShi(region);
        Thread.sleep(300);
        Match match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,1);
        if(null == match2){
             match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,3);
        }
        //6. 寻找教主
        Match jzMatch;
        int n = 1;
        region.type(Key.F1);
        while (true){
            n++;
            //点击随机石
            match2.doubleClick();
            CurrencyData.isTrue();
            //寻找教主
            jzMatch = CurrencyData.xszgRegion.wait(CurrencyData.xsJZ,1);
            if(null == jzMatch){
                jzMatch = CurrencyData.ckRegion.wait("D:/software/sikulix/img/qwmb.PNG", 1);
                if(null != jzMatch){
                    jzMatch.click();
                    jzMatch = CurrencyData.ckRegion.wait("D:/software/sikulix/img/qwmb.PNG", 1);
                    if(null != jzMatch){
                        jzMatch.click();
                    }
                    jzMatch = CurrencyData.xszgRegion.wait(CurrencyData.xsJZ,4);
                    if(null != jzMatch){
                        jzMatch.click();
                    }else {
                        jzMatch = CurrencyData.bgRegion.wait(CurrencyData.BGuo,1);
                        if(null != jzMatch){
                            jzMatch.setY(jzMatch.getY()-60);
                            jzMatch.click();
                        }
                    }
                }
            }
            //寻找教主
            jzMatch = CurrencyData.xszgRegion.wait(CurrencyData.xsJZ,2);
            //如果找到教主了推出循环
            if (null != jzMatch){
                break;
            }
            //查看是否在新手
            if((n%5)==0){
               SuiJiShi.isXinShou(region);
            }
            if(n > 40){
                //随机40次没有怪后，调用随机石方法
                System.out.println("随机石超过40检查包裹");
                SuiJiShi.suiJiShi(region);
                n = 1;
                ATuLongDianStart.tld(region);
            }
            //寻找随机石，因为有可能随机石在其它位置了，所以在查一遍
            match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,1);
            if(null == match2){
                match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,3);
            }
        }

        //7. 循环打怪直到没有怪为止,防止没打完，调用两次
        System.out.println("调用打怪开始！！！！！！");
        XsDaGuai.xsDaguai(region);
        System.out.println("调用打怪结束~~~~~~~~~~~");
        //检查宝宝药品
        SikYaoPin.bbYaoPin(region);
        //捡装备
        System.out.println("调用捡装备开始！！！！！！");
        SikJZB.pickup();
        region.type(Key.F1);
        System.out.println("调用捡装备结束！！！！！！");

        //8. 回收装备
        match2 = region.wait("D:/software/sikulix/image/baoguo.PNG",1);
        match2.click();
        Iterator<Match> all = CurrencyData.kgRegion.findAll("D:/software/sikulix/xinshou/kg.PNG");
        if(null == all || Iterators.size(all)<=4){
            System.out.println("回收装备开始~~~");
            //正常命令回收
            SikHS.hs(region);
            //无法在线回收情况回土城
          /*  if(null == all){
                match2 = CurrencyData.kgRegion.wait("D:/software/sikulix/image/xxy",1);
                if(null != match2){
                    //如果包裹满了将血药吃了
                    match2.doubleClick();
                    match2 = CurrencyData.kgRegion.wait("D:/software/sikulix/image/xxy",1);
                    if(null != match2){
                        //如果包裹满了将血药吃了
                        match2.doubleClick();
                    }
                }
            }
            tcHuiShou(region);*/
            System.out.println("回收装备结束~~~");
        }

        //11. 检查火龙之心等
        if((count%30)==0){
            CurrencyData.rhlmx();
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
        handler(region);
    }

    public static void tcHuiShou(Region region)throws Exception {
        Settings.MinSimilarity=0.7;
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(800);
        SikJZB.gb();
        //回城
        SuiJiShi.isHcs(region);
        //寻找装备回收
        Match match = region.wait("D:/software/sikulix/xinshou/hszb.PNG",1);
        int x =1;
        while (null == match){
            if((x%4)==0){
                SuiJiShi.isHcs(region);
            }
            //寻找界面下面菜单，调整鼠标位置人物下边移动
            match = region.find("D:/software/sikulix/tulongdian/tldyd.PNG");
            match.setX(match.getX()+180);
            match.setY(match.getY()-120);
            match.rightClick();
            Thread.sleep(500);
            match.rightClick();
            Thread.sleep(500);
            match.rightClick();
            match = region.wait("D:/software/sikulix/xinshou/hszb.PNG",1);
            Thread.sleep(500);
            CurrencyData.isTrue();
            x++;
        }
        Thread.sleep(500);
        match = region.wait("D:/software/sikulix/xinshou/hszb.PNG",3);
        if(null == match){
            tcHuiShou(region);
        }
        match.click();
        try {
            XinShouHS.xshs(region);
        } catch (Exception e) {
            e.printStackTrace();
            tcHuiShou(region);
        }
        AXinShouDianStart.xinshou(region);
    }
}
