package com;
import com.google.common.collect.Iterators;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.*;

import java.util.Iterator;
@Slf4j
public class SikTest {
    public static void main(String[] args)throws Exception{
        //x 是左右调节，y 是上下调节
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        //循环打怪
        //daGuai();

        //判断是否有随机石
         //suiJiShi();

         //捡装备
        jianZhuanBei();
    }

    /**
     * 捡装备
     * @throws Exception
     */
    public static void jianZhuanBei()throws Exception{
        Region region = new Region(0, 0,1300,1080);
        region.setThrowException(false);
        Match match = region.wait("D:/software/sikulix/image/xw.PNG", 2);
        pickup("D:/software/sikulix/image/xw.PNG");
    }
    public static void pickup(String target)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        Match match = region.find(target);
        Location location = match.getTarget();
        location.setY(100);
        location.click();

      /*  match.rightClick();
        if(null != match){
            while (null != match){
                match.click();
                Thread.sleep(500);
                match = region.find(target);
                Thread.sleep(500);
            }
        }*/
    }

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


    /**
     * 循环打怪，直到没有怪为止
     * @throws Exception
     */
    public static void daGuai()throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

        //循环打怪直到没有怪为止
        Match match3 = region.find("D:/software/sikulix/tulongdian/jiaozhu1.PNG");
        Match match4 = region.find("D:/software/sikulix/tulongdian/jiaozhu2.PNG");
        while (null != match4 || null != match3){
            try {
                Thread.sleep(500);
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
            } catch (Exception e) {
                match3 = region.find("D:/software/sikulix/tulongdian/jiaozhu1.PNG");
                match4 = region.find("D:/software/sikulix/tulongdian/jiaozhu2.PNG");
                System.out.println("失败~~~"+match3+"；"+match4);
            }
        }
    }
}

