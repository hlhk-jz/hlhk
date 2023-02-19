package com;
import org.sikuli.script.*;

import java.util.List;

public class SikHandler {
    private static long count = 0;
    private static Region yzz = new Region(0,0,1200,800);
    public static void show(Region region)throws Exception {
        //如果是在土城，就找新手打宝/屠龙殿地图
        Thread.sleep(1000);
        Match match = region.wait("D:/software/sikulix/image/tc.PNG",1);
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
        Match match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
        if(null == match2){
            match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",1);
        }
        //6. 寻找教主
        Match match3 = null;
        int n = 1;
        boolean isTrue = true;
        while (true){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(500);
            //寻找教主
            List<Match> any = region.findAnyList(SikDaGuai.guaiList());
            Thread.sleep(1000);
            if(any.isEmpty()){
                Match matchyd = region.find("D:/software/sikulix/tulongdian/tldyd.PNG");
                Thread.sleep(500);
                match3 = region.wait("D:/software/sikulix/image/youxia.PNG",0.3);
                if(null != match3){
                    //右下
                    System.out.println("右下！！！！！！！");
                    isTrue = false;
                    matchyd.setY(matchyd.getY()-100);
                    matchyd.setX(matchyd.getX()+400);
                    matchyd.rightClick();
                    Thread.sleep(600);
                    matchyd.rightClick();
                    Thread.sleep(300);
                }
                if(isTrue){
                    //左上
                    match3 = region.wait("D:/software/sikulix/image/zuoshang.PNG",0.3);
                    if(null != match3){
                        System.out.println("左上！！！！！！！");
                        isTrue = false;
                        matchyd.setY(matchyd.getY()-500);
                        matchyd.setX(matchyd.getX()-80);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(300);
                    }
                }
                if(isTrue){
                    //左下
                    match3 = region.wait("D:/software/sikulix/image/zuoxia.PNG",0.3);
                    if(null != match3){
                        System.out.println("左下！！！！！！！");
                        isTrue = false;
                        matchyd.setY(matchyd.getY()-100);
                        matchyd.setX(matchyd.getX()-100);
                        matchyd.rightClick();
                        Thread.sleep(600);
                        matchyd.rightClick();
                        Thread.sleep(300);
                    }
                }
            }
            //寻找教主
            any = region.findAnyList(SikDaGuai.guaiList());
            Thread.sleep(1000);
            //如果找到教主了推出循环
            if (!any.isEmpty()){
                break;
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
        SikDaGuai.daGuai(region);
        region.setY(0);
        region.setX(0);
        region.setW(1200);
        region.setH(800);

        //8. 打完怪捡装备,防止漏捡，调用两次
        region.type(Key.F12);
        SikJZB.pickup(region);
        SikJZB.pickup(region);

        //9. 回收
        if((count%5)==0){
            System.out.println("回收装备开始！！！！count："+count);
            SikHS.jzb(region);
            System.out.println("回收装备结束~~~~~~~~");
        }
        //10. 检查药品,主号和宝宝
        System.out.println("检查主号和宝宝药品开始~~~~~~~~");
        SikYaoPin.zhYaoPin(region);
        SikYaoPin.bbYaoPin(region);
        System.out.println("检查主号和宝宝药品结束。。。。。。");

        //11. 检查火龙之心
        if((count%100)==0){
            //修装备
            HLZX.hlzx(region);
            //检查磨血石
            MoXueShi.jcMXS(region);
            //修复装备
            XiuFuZB.xfzb(region);
        }

        //12. 循环地柜
        System.out.println("~~~~~~~~~~~本次超级循环数量："+count);
        show(region);
    }
}
