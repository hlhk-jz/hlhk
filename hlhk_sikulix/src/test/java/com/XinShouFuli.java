package com;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//新手福利地图
public class XinShouFuli {
    public static void main(String[] args){
        Region region = new Region(0, 0,1500,900);
        region.setThrowException(false);
        try {
            xin(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xin(Region region)throws Exception{
        Match match = null;
        //寻找新手福利NPC
        match = region.wait("D:/software/sikulix/image/fuli.PNG",1);
        int x = 1;
        while (null == match){
            if((x%3)==0){
                isHcs(region);
            }
            //寻找 out 按键，调整鼠标位置向下移动
            match = region.find("D:/software/sikulix/image/init.PNG");
            Thread.sleep(500);
            Location target = match.getTarget();
            System.out.println("x="+target.getX()+",y="+target.getY());
            target.setY(target.getY()-200);
            target.setX(target.getX()-250);
            target.rightClick();
            match = region.wait("D:/software/sikulix/image/fuli.PNG",1);
            x++;
        }
        match.click();
        //寻找进入
        match = region.wait("D:/software/sikulix/image/ru.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/ru.PNG",1);
        }
        //我要进入
        match.click();
        SikHandler.tulongdianMethod(region);
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
    }
}
