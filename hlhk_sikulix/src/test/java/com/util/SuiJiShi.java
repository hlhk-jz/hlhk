package com.util;
import com.tld.ATuLongDianStart;
import com.xinshou.AXinShouDianStart;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class SuiJiShi {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        for (int i = 0;i<5;i++){
            suiJiShi(region);
            Thread.sleep(500);
        }
    }
    //查看随机石是否充足
    public static void suiJiShi(Region region)throws Exception{
        SikJZB.gb(region);
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(900);
        //寻找包裹
        Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        match.click();
        //寻找刷新按键
        match = region.wait("D:/software/sikulix/image/sxbg.PNG", 1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/sxbg1.PNG", 1);
        }
        if(null != match){
            match.click();
        }
        //查看随机石
        match = CurrencyData.kgRegion.wait("D:/software/sikulix/tulongdian/shitou4.PNG",2);
        if(null == match){
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


    //点击回城石
    public static void isHcs(Region region)throws Exception{
        Match match = null;
        //寻找包裹
        match = region.wait("D:/software/sikulix/image/baoguo.PNG",1);
        match.click();
        //寻找回城石
        match = region.wait("D:/software/sikulix/image/hc.PNG",1);
        while (null == match){
            //寻找包裹
            match = region.wait("D:/software/sikulix/image/baoguo.PNG",1);
            match.click();
            //寻找回城石
            match = region.wait("D:/software/sikulix/image/hc.PNG",1);
            if(null == match){
                //如果包裹没有回城石，寻找商城
                match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                match.click();
                //寻找补给
                match = region.wait("D:/software/sikulix/image/bj.PNG",1);
                if(null == match){
                    match = region.wait("D:/software/sikulix/image/bj2.PNG",1);
                }
                match.click();
                //寻找回城石
                match = region.wait("D:/software/sikulix/image/sphc.PNG",1);
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
        }
        match.doubleClick();
        Thread.sleep(500);
        //关闭物品栏
        match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
        if(null != match){
            match.click();
        }
    }

    //判断是否在屠龙殿
    public static void isTuLd(Region region)throws Exception{
        Settings.MinSimilarity=0.9;
        region.setX(0);
        region.setY(601);
        region.setW(168);
        region.setH(244);
        Match wait = region.wait("D:/software/sikulix/image/tldimg.PNG", 0.5);
        Settings.MinSimilarity=0.7;
        region.setX(0);
        region.setY(0);
        region.setW(1000);
        region.setH(800);
        if(null == wait){
            ATuLongDianStart.tld(region);
        }
    }

    //判断是否在新手地图
    public static void isXinShou(Region region)throws Exception{
        Settings.MinSimilarity=0.9;
        region.setX(0);
        region.setY(601);
        region.setW(168);
        region.setH(244);
        Match wait = region.wait("D:/software/sikulix/xinshou/xsdb.PNG", 0.5);
        Settings.MinSimilarity=0.7;
        region.setX(0);
        region.setY(0);
        region.setW(1000);
        region.setH(800);
        if(null == wait){
            AXinShouDianStart.xinshou(region);
        }
    }
}
