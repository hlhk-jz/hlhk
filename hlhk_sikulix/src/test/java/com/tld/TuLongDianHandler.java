package com.tld;
import com.google.common.collect.Iterators;
import com.util.*;
import com.xinshou.AXinShouDianStart;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TuLongDianHandler {
    private static long count = 1;

    public static void handler(Region region)throws Exception {
        //判断是否在屠龙殿地图
        Thread.sleep(300);
        SuiJiShi.isTuLd(region);
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
            jzMatch = region.wait(CurrencyData.tldJZ,1);
            if(null == jzMatch){
                jzMatch = CurrencyData.ckRegion.wait("D:/software/sikulix/img/qwmb.PNG", 1);
                if(null != jzMatch){
                    jzMatch.click();
                    jzMatch = CurrencyData.ckRegion.wait("D:/software/sikulix/img/qwmb.PNG", 1);
                    if(null != jzMatch){
                        jzMatch.click();
                    }
                    jzMatch = CurrencyData.xszgRegion.wait(CurrencyData.tldJZ,4);
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
            jzMatch = CurrencyData.xszgRegion.wait(CurrencyData.tldJZ,2);
            //如果找到教主了推出循环
            if (null != jzMatch){
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
                AXinShouDianStart.xinshou(region);
            }
            //寻找随机石，因为有可能随机石在其它位置了，所以在查一遍
            match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,1);
            if(null == match2){
                match2 = CurrencyData.zblSjsRegion.wait(CurrencyData.zblSjs,3);
            }
        }

        //7. 循环打怪直到没有怪为止,防止没打完，调用两次
        System.out.println("调用打怪开始！！！！！！");
        TldDaGuai.zdDaguai(region);
        System.out.println("调用打怪结束~~~~~~~~~~~");
        //检查宝宝药品
        SikYaoPin.zhYaoPin(region);
        SikYaoPin.bbYaoPin(region);

        //8. 打完怪捡装备,防止漏捡，调用多次
        System.out.println("调用捡装备开始！！！！！！");
        SikJZB.pickup();
        region.type(Key.F1);
        System.out.println("调用捡装备结束！！！！！！");
        //9. 回收
        match2 = CurrencyData.bgRegion.wait(CurrencyData.BGuo,1);
        match2.click();
        //如果有100元宝点了
        Match wait = CurrencyData.kgRegion.wait("D:/software/sikulix/image/yuanbao.PNG", 1);
        while (null != wait){
            wait.doubleClick();
            CurrencyData.isTrue();
            wait = CurrencyData.kgRegion.wait("D:/software/sikulix/image/yuanbao.PNG", 1);
        }
        Iterator<Match> all = CurrencyData.kgRegion.findAll("D:/software/sikulix/xinshou/kg.PNG");
        if(null == all || Iterators.size(all)<=4){
            System.out.println("回收装备开始~~~");
            SikHS.hs(region);
            System.out.println("回收装备结束~~~");
        }
        //10. 火龙之心等。。
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
}
