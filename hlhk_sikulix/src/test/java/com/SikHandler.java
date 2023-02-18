package com;
import org.sikuli.script.*;
public class SikHandler {
    private static long count = 3;
    public static void tulongdianMethod(Region region)throws Exception {
        //如果是在土城，就找新手打宝
        Thread.sleep(1000);
        Match match = region.wait("D:/software/sikulix/image/tc.PNG",1);
        if(null != match){
            //新手地图
            XinShouFuli.xin(region);
            //屠龙殿地图
            //TuLongDian.tld(region);
        }
        count ++;
        //5. 寻找随机石
        SuiJiShi.suiJiShi(region);
        Thread.sleep(1000);
        Match match2 = region.find("D:/software/sikulix/tulongdian/shitou.PNG");
        Thread.sleep(1000);
        if(null == match2){
            match2 = region.find("D:/software/sikulix/tulongdian/shitou2.PNG");
            Thread.sleep(1000);
        }
        //6. 寻找教主
        Match match3 = null;
        int n = 1;
        while (null == match3){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(1000);
            //寻找教主
            match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",0.5);
            //寻找随机石，因为有可能随机石在其它位置了，所以在查一遍
            match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",0.5);
            //如果找到教主了推出循环
            if (null != match3){
                break;
            }
            if(n > 40){
                //随机40次没有怪后，调用随机石方法
                System.out.println("随机石超过40检查包裹");
                SuiJiShi.suiJiShi(region);
                n = 1;
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
        if((count%2)!=0){
            SikHS.jzb(region);
        }

        //10. 检查药品,主号和宝宝
        SikYaoPin.zhYaoPin(region);
        SikYaoPin.bbYaoPin(region);

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
        tulongdianMethod(region);
    }
}
