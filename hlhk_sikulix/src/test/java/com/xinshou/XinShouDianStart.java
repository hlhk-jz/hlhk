package com.xinshou;
import com.util.CurrencyData;
import com.util.SuiJiShi;
import com.tld.SikHandler;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//屠龙殿
public class XinShouDianStart {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);
        try {
            xinshou(region);
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
                wait.click();
                wait = region.wait("D:/software/sikulix/image/qdtc.PNG", 0.8);
                wait.click();
                Thread.sleep(5000);
                wait = region.wait("D:/software/sikulix/image/ksjr.PNG", 0.8);
                wait.click();
                Thread.sleep(5000);
                wait = region.wait("D:/software/sikulix/image/qdjr.PNG", 0.8);
                wait.click();
                Thread.sleep(2000);
                xinshou(region);
            }
        }
    }

    public static void xinshou(Region region)throws Exception{
        Match match = null;
        //寻找新手福利NPC
        match = region.wait(CurrencyData.xsNPC,1);
        int x = 1;
        while (null == match){
            if((x%5)==0){
                SuiJiShi.isHcs(region);
            }
            //寻找界面下面菜单，调整鼠标位置人物向下边移动
            match = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
            match.setY(match.getY()-150);
            match.setX(match.getX()+160);
            match.hover();
            Thread.sleep(300);
            match.rightClick();
            Thread.sleep(300);
            match.rightClick();
            Thread.sleep(300);
            match.rightClick();
            match = region.wait(CurrencyData.xsNPC,1);
            x++;
        }
        match.click();

        //寻找进入
        match = region.wait("D:/software/sikulix/image/ru.PNG",2);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/ru.PNG",2);
        }
        match.click();
        XSHandler.show(region);
    }
}
