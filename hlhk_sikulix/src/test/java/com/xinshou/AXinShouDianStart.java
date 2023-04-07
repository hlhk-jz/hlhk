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
    static int x = 1;
    public static void xinshou(Region region){
        try {
            if(x == 1){
                SikJZB.gb();
                //检查宝宝是否在线
                BaoBao.baobao(region);
                //将F12移动到聊天栏
                //ChunShi.yd(region);
                //检查药品
                SikYaoPin.bbYaoPin(region);
                SikYaoPin.zhYaoPin(region);
            }
            //关闭弹窗
            SikJZB.gb();
            //寻找新手npc
            Match match = region.wait(CurrencyData.xsNpc,1);
            while (null == match){
                if((x%3)==0){
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
                CurrencyData.isTrue();
                x++;
            }
            match.click();
            //寻找进入
            match = region.wait("D:/software/sikulix/image/ru.PNG",2);
            if(null == match){
                xinshou(region);
            }
            //我要进入
            x = 1;
            match.click();
            XinShouHandler.handler(region);
        } catch (Exception e) {
            e.printStackTrace();
            CurrencyData.isTrue();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            xinshou(region);
        }
    }
}
