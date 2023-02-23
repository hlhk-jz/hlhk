package com;
import org.sikuli.script.*;
import org.sikuli.basics.Settings;
import java.util.List;

public class SikHandler {
    private static long count = 0;

    public static void show(Region region)throws Exception {

        //如果是在土城，就找新手打宝/屠龙殿地图
        Thread.sleep(500);
        Match match = region.wait(CurrencyData.tcNpc,1);
        if(null != match){
            //新手地图
            //AXinShouFuliStart.xin(region);
            //屠龙殿地图
            ATuLongDianStart.tld(region);
        }
        count ++;

        //5. 寻找随机石
        SuiJiShi.suiJiShi(region);
        Thread.sleep(1000);
        Match match2 = region.wait(CurrencyData.zblSjs,0.5);
        if(null == match2){
            match2 = region.wait(CurrencyData.zblSjs,1);
        }

        //6. 寻找教主
        Match yd = null;
        int n = 1;
        while (true){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(500);
            //寻找教主
            List<Match> anyList = region.findAnyList(CurrencyData.jzList());
            Thread.sleep(1000);
            if(anyList.isEmpty()){
                yd = region.wait("D:/software/sikulix/image/youxia.PNG",0.3);
                if(null != yd && (n%2)==0){
                    //右下
                    Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-100);
                    matchyd.setX(matchyd.getX()+400);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(300);
                }
                if(null != yd && (n%2)!=0){
                    //左上
                    Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                    matchyd.setY(matchyd.getY()-500);
                    matchyd.setX(matchyd.getX()-80);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(300);
                }
            }
            //寻找教主
            anyList = region.findAnyList(CurrencyData.jzList());
            Thread.sleep(1000);
            //如果找到教主了推出循环
            if (!anyList.isEmpty()){
                break;
            }
            if((n%10)==0){
                Settings.MinSimilarity=0.9;
                region.setX(0);
                region.setY(601);
                region.setW(168);
                region.setH(244);
                Match wait = region.wait("D:/software/sikulix/image/mzs.PNG", 0.5);
                Settings.MinSimilarity=0.7;
                region.setX(0);
                region.setY(0);
                region.setW(1000);
                region.setH(800);
                if(null != wait){
                    ATuLongDianStart.tld(region);
                }
            }
            if(n > 40){
                //随机40次没有怪后，调用随机石方法
                System.out.println("随机石超过40检查包裹");
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
        SikDaGuai.daGuai(region);
        System.out.println("调用打怪结束~~~~~~~~~~~");

        //8. 打完怪捡装备,防止漏捡，调用多次
        region.type(Key.F12);
        System.out.println("调用捡装备开始！！！！！！");
        SikJZB.pickup();
        SikJZB.pickup();
        region.type(Key.F1);
        System.out.println("调用捡装备结束！！！！！！");
        //9. 回收
        if((count%5)==0){
            System.out.println("回收装备开始！！！！count："+count);
            SikHS.jzb(region);
            System.out.println("回收装备结束~~~~~~~~");
        }
        //10. 检查药品,主号和宝宝
      /*  System.out.println("检查主号和宝宝药品开始~~~~~~~~");
        SikYaoPin.zhYaoPin(region);
        SikYaoPin.bbYaoPin(region);
        System.out.println("检查主号和宝宝药品结束。。。。。。");*/

        //11. 检查火龙之心等
        if((count%100)==0){
            //火龙之心
            HLZX.hlzx(region);
            //检查磨血石，如果有人龙印只修装备就可以
           // MoXueShi.jcMXS(region);
            //修复装备
            XiuFuZB.xfzb(region);
        }

        //12. 循环地柜
        System.out.println("~~~~~~~~~~~本次超级循环数量："+count);
        show(region);
    }
}
