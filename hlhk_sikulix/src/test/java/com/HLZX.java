package com;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.List;

//检查火龙之心
public class HLZX {
  /*  public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        hlzx(region);
    }*/

    public static void hlzx(Region region){
        try {
            Match match;
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
            match = region.wait("D:/software/sikulix/image/hlzx.PNG", 1);
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
            List<Match> matchGbs = region.findAnyList(SikJZB.initGBListObj());
            if(!matchGbs.isEmpty()){
                for (Match match1 : matchGbs){
                    match1.click();
                    Thread.sleep(800);
                    match1.click();
                }
            }
        } catch (Exception findFailed) {
            hlzx(region);
            findFailed.printStackTrace();
        }
    }
}
