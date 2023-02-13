package com;
import com.google.common.collect.Iterators;
import org.sikuli.script.*;
import java.util.Iterator;
public class SikHandler {
    private static long count = 3;
    public static void main(String[] args){
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        try {
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
        }catch (Exception e){
            e.getStackTrace();
        }

    }

    private static void tulongdianMethod(Region region)throws Exception {
        count ++;
        Location location;
        //5. 寻找随机石
        suiJiShi();
        Match match2 = region.find("D:/software/sikulix/tulongdian/shitou.PNG");
        if(null == match2){
            match2 = region.find("D:/software/sikulix/tulongdian/shitou.PNG");
        }
        Thread.sleep(300);
        //6. 寻找教主
        Match match3 = null;
        Match match5 = null;
        int n = 1;
        while (null == match3){
            n++;
            //点击随机石
            match2.doubleClick();
            Thread.sleep(2000);
            //寻找教主
            match3 = region.find("D:/software/sikulix/image/jiaozhu1.PNG");
            //如果找到教主了推出循环
            if (null != match3){
                break;
            }
            if(n > 40){
                //随机40次没有怪后，调用随机石方法
                System.out.println("随机石超过40检查包裹");
                suiJiShi();
                n = 1;
            }
        }

        //7. 循环打怪直到没有怪为止
        int i = 1;
        Match match4 = null;
        while (null != match4 || null != match3 || null != match5){
            i++;
            try {
                match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",1);
                if(null != match3){
                    location = match3.getTarget();
                    location.setY(location.getY()+30);
                    location.click();
                    region.type(Key.F3);
                }
                if(null == match3){
                    match4 = region.wait("D:/software/sikulix/image/jiaozhu2.PNG",1);
                    if(null != match4){
                        location = match4.getTarget();
                        location.setY(location.getY()+30);
                        location.click();
                        region.type(Key.F3);
                    }
                    if(null == match4){
                        match5 = region.wait("D:/software/sikulix/image/jiaozhu3.PNG",1);
                        if(null != match5){
                            location = match5.getTarget();
                            location.setY(location.getY()+30);
                            location.click();
                            region.type(Key.F3);
                        }
                    }
                }
                match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",1);
                if(null == match3){
                    match4 = region.wait("D:/software/sikulix/image/jiaozhu2.PNG",1);
                    if(null == match4){
                        match5 = region.wait("D:/software/sikulix/image/jiaozhu3.PNG",1);
                    }
                }
                Thread.sleep(500);
            } catch (Exception e) {
                match3 = region.wait("D:/software/sikulix/image/jiaozhu1.PNG",1);
                match4 = region.wait("D:/software/sikulix/image/jiaozhu2.PNG",1);
                match5 = region.wait("D:/software/sikulix/image/jiaozhu3.PNG",1);
                System.out.println("失败~~~"+match3+"；"+match4+":"+match5);
            }
            if(i == 100){
                //如果打怪循环100次，放弃该次打怪
                System.out.println("打怪循环100次，重新随机");
                tulongdianMethod(region);
            }
        }

        //8. 打完怪捡装备
        SikJZB.pickup();

        //9. 回收
        if((count%2)!=0){
            System.out.println("回收装备开始：count："+count);
            SikHS.jzb();
        }

        //10. 检查药品
        SikYaoPin.yaoPin();

        //11. 循环地柜
        //tulongdianMethod(region);
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
