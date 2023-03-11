package com.xinshou;

import com.util.*;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

public class XinShouHandler {
    private static long count = 0;

    public static void handler(Region region)throws Exception {
        //判断是否在新手地图
        Thread.sleep(500);
        SuiJiShi.isXinShou(region);
        count ++;
        //5. 寻找随机石
        SuiJiShi.suiJiShi(region);
        Thread.sleep(1000);
        Match match2 = region.wait(CurrencyData.zblSjs,1);
        if(null == match2){
            match2 = region.wait(CurrencyData.zblSjs,1);
        }

        //6. 寻找教主
        Match jzMatch = null;
        Match yd = null;
        int n = 1;
        while (true){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(500);
            //寻找教主
            jzMatch = region.wait(CurrencyData.tldJZ,1);
            if(null == jzMatch){
                Match matchyd;
                yd = region.wait("D:/software/sikulix/image/youxia.PNG",0.3);
                if(null != yd){
                    //右下
                    matchyd= region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setX(matchyd.getX()+400);
                    matchyd.setY(matchyd.getY()-500);
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
                    jzMatch = region.wait(CurrencyData.tldJZ,1);
                    if(null == jzMatch){
                        //左上
                        matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                        matchyd.setY(matchyd.getY()-150);
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
            jzMatch = region.wait(CurrencyData.tldJZ,1);
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
            }
            //寻找随机石，因为有可能随机石在其它位置了，所以在查一遍
            match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
            if(null == match2){
                match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",0.5);
            }
        }

        //7. 循环打怪直到没有怪为止,防止没打完，调用两次
        System.out.println("调用打怪开始！！！！！！");
        XsDaGuai.xsDaguai(region,jzMatch);
        jzMatch = region.wait(CurrencyData.xsJZ,1);
        if(null != jzMatch){
            XsDaGuai.xsDaguai(region,jzMatch);
        }
        System.out.println("调用打怪结束~~~~~~~~~~~");

        //捡装备
        SikJZB.pickup();

        //8. 回收装备
        if((count % 3)== 0){
            tcHuiShou(region);
        }

        //11. 检查火龙之心等
        /*if((count%10)==0){
            //火龙之心
            System.out.println("检查宝宝火龙之心修复装备开始！时间："+System.currentTimeMillis()/1000);
            HLZX.hlzx(region);
            //检查磨血石，如果有人龙印只修装备就可以
            MoXueShi.jcMXS(region);
            //修复装备
            XiuFuZB.xfzb(region);
            System.out.println("火龙之心检查装备结束！时间："+System.currentTimeMillis()/1000);
        }*/
            //火龙之心
            System.out.println("检查宝宝火龙之心修复装备开始！时间："+System.currentTimeMillis()/1000);
            HLZX.hlzx(region);
            //检查磨血石，如果有人龙印只修装备就可以
            MoXueShi.jcMXS(region);
            //修复装备
            XiuFuZB.xfzb(region);
            System.out.println("火龙之心检查装备结束！时间："+System.currentTimeMillis()/1000);
        //12. 循环地柜
        System.out.println("~~~~~~~~~~~本次超级循环数量："+count);
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(800);
        Settings.MinSimilarity= 0.7;
        handler(region);
    }

    private static void tcHuiShou(Region region)throws Exception {
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
            x++;
        }
        match.click();
        XinShouHS.xshs(region);
        AXinShouDianStart.xinshou(region);
    }
}
