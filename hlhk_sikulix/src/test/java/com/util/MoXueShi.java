package com.util;

import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.List;

//检查磨血石
public class MoXueShi {
    public static void main(String[] args){
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        jcMXS(region);
    }

    public static void jcMXS(Region region){
        try {
            SikJZB.gb();
            CurrencyData.isTrue();
            Match match;
            region.setX(0);
            region.setY(0);
            region.setW(1200);
            region.setH(800);
            Settings.MinSimilarity = 0.7;
            //寻找背包
            match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
            match.click();
            //寻找魔血石
            match = region.wait("D:/software/sikulix/image/mxs2.PNG", 1);
            while (null != match){
                match.click();
                Thread.sleep(500);
                //寻找包裹，鼠标悬浮上方，单机把旧的扔掉
                match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
                match.setY(match.getY()-100);
                match.hover();
                Thread.sleep(500);
                match.click();
                Thread.sleep(500);
                CurrencyData.isTrue();
                //寻找魔血石
                match = region.wait("D:/software/sikulix/image/mxs2.PNG", 1);
            }

            //寻找商铺
            match = region.wait("D:/software/sikulix/image/pu.PNG",1);
            match.click();
            //寻找补给
            match = region.wait("D:/software/sikulix/image/bj.PNG", 1);
            if (null == match){
                match = region.wait("D:/software/sikulix/image/bj2.PNG", 4);
            }
            match.click();
            //寻找魔血石
            match = region.wait("D:/software/sikulix/image/mxs.PNG",1);
            match.click();
            //购买
            match = region.wait("D:/software/sikulix/image/gm.PNG",1);
            match.click();
            //确定
            match = region.wait("D:/software/sikulix/image/qd.PNG",1);
            match.click();
            //购买
            match = region.wait("D:/software/sikulix/image/gm.PNG",1);
            match.click();
            //确定
            match = region.wait("D:/software/sikulix/image/qd.PNG",1);
            match.click();
            //关闭商铺栏
            match = region.wait("D:/software/sikulix/image/gbspl.PNG", 1);
            if(null != match){
                match.click();
            }
            //寻找魔血石
            match = region.wait("D:/software/sikulix/image/mxs2.PNG", 1);
            match.rightClick();
            //再次寻找磨血石，双击换主号磨血石
            match = region.wait("D:/software/sikulix/image/mxs2.PNG", 1);
            match.doubleClick();
            //再次寻找磨血石，扔掉
            match = region.wait("D:/software/sikulix/image/mxs2.PNG", 1);
            if(null != match){
                match.click();
                match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
                match.setY(match.getY()-100);
                match.hover();
                Thread.sleep(500);
                match.click();
            }
            //关闭物品栏
            SikJZB.gb();
            //寻找宝宝包裹
            match = region.wait("D:/software/sikulix/image/bbbg.PNG", 1);
            match.click();
            //寻找宝宝包裹磨血石
            match = region.wait("D:/software/sikulix/image/bbmxs.PNG", 1);
            match.doubleClick();
            Thread.sleep(500);
            match.click();
            //关闭弹窗
            SikJZB.gb();
            match.click();
            System.out.println("更换魔血石成功~~~~~~~~");
        }catch (Exception e){
            e.printStackTrace();
            //检查宝宝是否在线
            BaoBao.baobao(region);
            jcMXS(region);
        }
    }
}
