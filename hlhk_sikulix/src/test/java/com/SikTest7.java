package com;
import com.google.common.collect.Iterators;
import org.sikuli.script.*;

import java.util.Iterator;

//新手福利
public class SikTest7 {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

        //1 新手福利npc
        Match match = region.find("D:/software/sikulix/image/fuli.PNG");
        if(null != match){
            Thread.sleep(300);
            //2. 点击新手福利
            match.click();
            //3.寻找屠龙殿界面
            match = region.find("D:/software/sikulix/image/ru.PNG");
            Thread.sleep(600);
            if(null == match){
                match = region.find("D:/software/sikulix/image/ru.PNG");
            }
            //4. 我要进入
            match.click();
            tulongdianMethod(region);
        }
    }

    private static void tulongdianMethod(Region region)throws Exception {
        //5. 寻找随机石
        suiJiShi();
        Match match2 = region.find("D:/software/sikulix/tulongdian/shitou.PNG");
        if(null == match2){
            match2 = region.find("D:/software/sikulix/tulongdian/shitou.PNG");
        }
        Thread.sleep(300);
        //6. 寻找教主
        Match match3 = null;
        while (null == match3){
            //点击随机石
            match2.doubleClick();
            Thread.sleep(2000);
            //寻找教主
            match3 = region.find("D:/software/sikulix/image/jiaozhu1.PNG");
            //如果找到教主了推出循环
            if (null != match3){
                break;
            }
        }

        //7. 循环打怪直到没有怪为止
        Match match4 = null;
        while (null != match4 || null != match3){
            try {
                if(null != match3){
                    match3.click();
                    region.type(Key.F3);
                }else {
                    Thread.sleep(500);
                    match4.click();
                    region.type(Key.F3);
                }
                match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",2);
                if(null == match3){
                    match4 = region.wait("D:/software/sikulix/image/jiaozhu2.PNG",2);
                }
                Thread.sleep(500);
            } catch (Exception e) {
                match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",3);
                match4 = region.wait("D:/software/sikulix/image/jiaozhu2.PNG",3);
                System.out.println("失败~~~"+match3+"；"+match4);
            }
        }

        //8. 打完怪捡装备

        //9. 回收

        //10. 查看药品是否没有了，没有就买点


        tulongdianMethod(region);
    }

    //查看随机石是否充足
    public static void suiJiShi()throws Exception{
        Region region = new Region(0, 0,1300,1080);
        region.setThrowException(false);

        //寻找包裹
        Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
        match.click();
        //查看随机石总数
        Iterator<Match> all = region.findAll("D:/software/sikulix/image/shitou.PNG");
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


