package com.xinshou;
import com.util.CurrencyData;
import com.util.SikJZB;
import com.util.SuiJiShi;
import com.tld.SikHandler;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//新手地图
public class XinShouDianStart {
    public static void main(String[] args){
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);
        xinshou(region);
    }

    public static void xinshou(Region region){
        try {
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
            while (null == match){
                SikJZB.gb(region);
                match = region.wait(CurrencyData.xsNPC,1);
                match.click();
                Thread.sleep(400);
                match = region.wait("D:/software/sikulix/image/ru.PNG",2);
            }
            match.click();
            XSHandler.show(region);
        }catch (Exception e){
            e.printStackTrace();
            xinshou(region);
        }
    }
}
