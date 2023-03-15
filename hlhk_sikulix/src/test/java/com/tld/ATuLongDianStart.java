package com.tld;
import com.util.*;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.List;

//屠龙殿
public class ATuLongDianStart {
    public static void main(String[] args){
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        tld(region);
    }

    public static void tld(Region region){
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
            //将F12移动到聊天栏
            ChunShi.yd(region);
            //检查药品
            SikYaoPin.zhYaoPin(region);
            SikYaoPin.bbYaoPin(region);
            //关闭弹窗
            SikJZB.gb(region);
            Match match = null;
            //寻找屠龙殿NPC
            match = region.wait(CurrencyData.tldNpc,1);
            int x = 1;
            while (null == match){
                if((x%5)==0){
                    SuiJiShi.isHcs(region);
                }
                //寻找界面下面菜单，调整鼠标位置人物左边移动
                match = region.find("D:/software/sikulix/tulongdian/tldyd.PNG");
                Thread.sleep(500);
                match.setY(match.getY()-350);
                match.hover();
                Thread.sleep(500);
                match.rightClick();
                CurrencyData.isTrue(region,1 );
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
            SikHandler.handler(region);
        } catch (Exception e) {
            e.printStackTrace();
            CurrencyData.isTrue(region, 9999);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            tld(region);
        }
    }
}
