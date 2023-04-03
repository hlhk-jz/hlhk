package com.util;

import org.sikuli.script.Match;
import org.sikuli.script.Region;

//修复装备
public class XiuFuZB {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        xfzb(region);
    }

    public static void xfzb(Region region){
        try {
            SikJZB.gb();
            CurrencyData.isTrue(region);
            boolean isTrue = true;
            Match match;
            //寻找包裹
            match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
            match.click();
            //寻找包裹修复神石
            match = region.wait("D:/software/sikulix/image/xfss2.PNG", 2);
            if(null != match){
                match.doubleClick();
                isTrue = false;
            }

            if(isTrue){
                //寻找商铺点击
                match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                match.click();
                //寻找装饰点击
                match = region.wait("D:/software/sikulix/image/yaopin3.PNG",1);
                if(null == match){
                    match = region.wait("D:/software/sikulix/image/yaopin4.PNG",1);
                }
                match.click();
                //寻找修复神石
                match = region.wait("D:/software/sikulix/image/xfss.PNG",1);
                match.click();
                //购买确定
                match = region.wait("D:/software/sikulix/image/gm.PNG",1);
                match.click();
                match = region.wait("D:/software/sikulix/image/qd.PNG",1);
                match.click();
                //关闭商铺栏
                match = region.wait("D:/software/sikulix/image/gbspl.PNG", 2);
                if(null != match){
                    match.click();
                }
                //寻找包裹修复神石
                match = region.wait("D:/software/sikulix/image/xfss2.PNG", 2);
                if(null ==match){
                    //寻找包裹
                    match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
                    match.click();
                    match = region.wait("D:/software/sikulix/image/xfss2.PNG", 2);
                    if(null == match){
                        SikJZB.gb();
                        xfzb(region);
                    }
                }
                match.doubleClick();
            }
            //关闭包裹
            SikJZB.gb();
            System.out.println("修复装备成功~~~~~~~~");
        }catch (Exception e){
            e.printStackTrace();
            xfzb(region);
        }
    }
}
