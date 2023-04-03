package com.util;

import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.List;

//检查火龙之心
public class HLZX {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        hlzx(region);
    }

    public static void hlzx(Region region){
        try {
            SikJZB.gb();
            CurrencyData.isTrue(region);
            Match match;
            //寻找宝宝包裹
            match = region.wait("D:/software/sikulix/image/bbbg.PNG", 1);
            match.click();
            //寻找宝宝包裹火龙之心
            match = region.wait("D:/software/sikulix/image/hlzx.PNG", 1);
            if(null != match){
                match.click();
                //关闭弹窗
                SikJZB.gb();
                match.click();
            }
            //关闭弹窗
            SikJZB.gb();
            match = region.wait("D:/software/sikulix/image/pu.PNG", 1);
            match.click();
            //寻找补给
            match = region.wait("D:/software/sikulix/image/bj.PNG", 1);
            if (null == match){
                match = region.wait("D:/software/sikulix/image/bj2.PNG", 1);
            }
            match.click();
            match = region.wait("D:/software/sikulix/image/hlzx.PNG", 1);
            match.click();
            //找购买按键
            match = region.wait("D:/software/sikulix/image/gm.PNG", 1);
            match.click();
            //确定
            match = region.wait("D:/software/sikulix/image/qd.PNG", 1);
            match.click();
            //关闭商铺栏
            match = region.wait("D:/software/sikulix/image/gbspl.PNG", 1);
            if(null != match){
                match.click();
            }
            //寻找包裹
            match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
            match.click();
            //寻找包裹火龙之心
            match = region.wait("D:/software/sikulix/image/hlzx.PNG", 2);
            if(null == match){
                SikJZB.gb();
                match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
                match.click();
                match = region.wait("D:/software/sikulix/image/hlzx.PNG", 2);
            }
            match.rightClick();
            //关闭物品栏
            match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
            if(null != match){
                match.click();
            }
            //寻找宝宝包裹
            match = region.wait("D:/software/sikulix/image/bbbg.PNG", 1);
            match.click();
            //寻找宝宝包裹火龙之心
            match = region.wait("D:/software/sikulix/image/hlzx.PNG", 1);
            match.doubleClick();
            Thread.sleep(500);
            match.click();
            //关闭弹窗
            SikJZB.gb();
            match.click();
            System.out.println("更换火龙之心成功~~~~~~~~~~");
        }catch (Exception e){
            e.printStackTrace();
            //查看宝宝是否在线
            BaoBao.baobao(region);
            hlzx(region);
        }
    }
}
