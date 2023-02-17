package com;
import com.google.common.collect.Iterators;
import org.sikuli.script.*;
import java.util.Iterator;
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
        Location location;
        //5. 寻找随机石
        suiJiShi(region);
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
                suiJiShi(region);
                n = 1;
            }
        }

        //7. 循环打怪直到没有怪为止
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
            System.out.println("回收装备开始：count："+count);
            SikHS.jzb(region);
        }

        //10. 检查药品
        SikYaoPin.yaoPin();

        //11. 循环地柜
        tulongdianMethod(region);
    }

    //查看随机石是否充足
    public static void suiJiShi(Region region)throws Exception{
        //寻找包裹
        Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
        match.click();
        //查看随机石总数
        Thread.sleep(300);
        Iterator<Match> all = region.findAll("D:/software/sikulix/tulongdian/shitou3.PNG");
        Thread.sleep(1000);
        int size = Iterators.size(all);
        if(size < 3){
            //如果随机石小于3就在商城买点
            //如果没有随机石，在商城买，寻找商铺
            match = region.wait("D:/software/sikulix/image/pu.PNG", 2);
            match.click();
            //寻找补给
            match = region.wait("D:/software/sikulix/image/bj.PNG", 2);
            if (null == match){
                match = region.wait("D:/software/sikulix/image/bj2.PNG", 2);
            }
            match.click();
            //找石头
            match = region.wait("D:/software/sikulix/image/mst.PNG", 2);
            match.click();
            //找购买按键
            match = region.wait("D:/software/sikulix/image/gm.PNG", 2);
            match.click();
            //确定
            match = region.wait("D:/software/sikulix/image/qd.PNG", 2);
            match.click();
            //关闭商铺栏
            match = region.wait("D:/software/sikulix/image/gbspl.PNG", 2);
            if(null != match){
                match.click();
            }
        }
        //关闭物品栏
        match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
        if(null != match){
            match.click();
        }
    }
}
