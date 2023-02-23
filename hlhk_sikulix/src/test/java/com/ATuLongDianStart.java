package com;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//屠龙殿
public class ATuLongDianStart {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);
        try {
            tld(region);
        } catch (Exception e) {
            e.printStackTrace();
            region.setX(659);
            region.setY(561);
            region.setW(255);
            region.setH(181);
            Match wait = region.wait("D:/software/sikulix/image/out.PNG", 0.8);
            region.setX(0);
            region.setY(0);
            region.setW(1000);
            region.setH(800);
            if(null != wait){
                tld(region);
            }
        }
    }

    public static void tld(Region region)throws Exception{
        Match match = null;
        //寻找屠龙殿NPC
        match = region.wait(CurrencyData.tldNpc,1);
        int x = 1;
        while (null == match){
            if((x%5)==0){
                AXinShouFuliStart.isHcs(region);
            }
            //寻找界面下面菜单，调整鼠标位置人物左边移动
            match = region.find("D:/software/sikulix/tulongdian/tldyd.PNG");
            Thread.sleep(500);
            match.setY(match.getY()-350);
            match.hover();
            Thread.sleep(500);
            match.rightClick();
            match = region.wait("D:/software/sikulix/tulongdian/tld.PNG",1);
            x++;
        }
        match.click();
        //寻找进入
        match = region.find("D:/software/sikulix/tulongdian/tldb.PNG");
        Thread.sleep(600);
        if(null == match){
            match = region.find("D:/software/sikulix/tulongdian/tldb.PNG");
        }
        if(null == match){
            tld(region);
        }
        //我要进入
        match.click();
        SikHandler.show(region);
    }
}
