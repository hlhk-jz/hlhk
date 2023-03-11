package com.xinshou;
import com.util.*;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//新手
public class AXinShouDianStart {
    public static void main(String[] args){
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        xinshou(region);
    }

    public static void xinshou(Region region){
        try {
            //新区上线会有召唤，查看是否有
            Match match = region.wait("D:/software/sikulix/xinshou/zh.PNG", 1);
            if(null != match){
                match.click();
            }
            SikJZB.gb(region);
            //检查宝宝是否在线
            BaoBao.baobao(region);
            //将F12移动到聊天栏
            ChunShi.yd(region);
            //检查药品
            SikYaoPin.bbYaoPin(region);
            SikYaoPin.zhYaoPin(region);
            //关闭弹窗
            SikJZB.gb(region);
            //寻找新手npc
            match = region.wait(CurrencyData.xsNpc,1);
            int x = 1;
            while (null == match){
                if((x%4)==0){
                    SuiJiShi.isHcs(region);
                }
                //寻找界面下面菜单，调整鼠标位置人物下边移动
                match = region.find("D:/software/sikulix/tulongdian/tldyd.PNG");
                match.setX(match.getX()+180);
                match.setY(match.getY()-120);
                match.rightClick();
                Thread.sleep(500);
                match.rightClick();
                Thread.sleep(500);
                match.rightClick();
                match = region.wait(CurrencyData.xsNpc,2);
                x++;
            }
            match.click();
            //寻找进入
            match = region.wait("D:/software/sikulix/image/ru.PNG",2);
            if(null == match){
                xinshou(region);
            }
            //我要进入
            match.click();
            XinShouHandler.handler(region);
        } catch (Exception e) {
            e.printStackTrace();
            CurrencyData.isTrue(region, 9999);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            xinshou(region);
        }
    }
}