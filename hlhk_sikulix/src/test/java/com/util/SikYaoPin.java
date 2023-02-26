package com.util;

import com.google.common.collect.Iterators;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.Iterator;

/**
 * 检查药品
 */

public class SikYaoPin {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        zhYaoPin(region);
        //bbYaoPin(region);
    }

    public static void bbYaoPin(Region region)throws Exception {
        region.setW(1200);
        region.setH(1000);
        //寻找宝宝包裹
        Match match = region.wait("D:/software/sikulix/image/bbbg.PNG", 1);
        match.click();
        //寻找宝宝包裹大药品
        Iterator<Match> all = region.findAll("D:/software/sikulix/image/bbyp.PNG");
        int size = 0;
        if(null != all){
            size = Iterators.size(all);
        }
        //关闭宝宝包裹
        match = region.wait("D:/software/sikulix/image/bgbg.PNG",1);
        if(null != match){
            match.click();
        }

        if(size < 2){
            //寻找商铺
            match = region.wait("D:/software/sikulix/image/pu.PNG",1);
            if(null == match){
                region.setX(799);
                region.setY(581);
                region.setW(361);
                region.setH(305);
                match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                region.setX(0);
                region.setY(0);
                region.setW(1200);
                region.setH(800);
            }
            match.click();
            //寻找装饰
            match = region.wait("D:/software/sikulix/image/yaopin3.PNG",1);
            if(null == match){
                match = region.wait("D:/software/sikulix/image/yaopin4.PNG",1);
            }
            match.click();
            //寻找商铺药品
            match = region.wait("D:/software/sikulix/image/yaopin2.PNG",1);
            match.click();
            //购买确定
            match = region.wait("D:/software/sikulix/image/gm.PNG",1);
            match.click();
            match = region.wait("D:/software/sikulix/image/qd.PNG",1);
            match.click();
            //关闭商铺栏
            match = region.wait("D:/software/sikulix/image/gbspl.PNG", 1);
            if(null != match){
                match.click();
            }
            //寻找包裹
            match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
            match.click();
            //主号包裹中大药
            match = region.wait("D:/software/sikulix/image/zhdy.PNG", 1);
            match.rightClick();
            Thread.sleep(500);
            //关闭包裹
            match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
            if(null != match){
                match.click();
            }

        }
    }

    public static void zhYaoPin(Region region)throws Exception{
            Match match = null;
            //寻找包裹
            match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
            match.click();
            int size = 0;

            Iterator<Match> all = region.findAll("D:/software/sikulix/image/yaopin1.PNG");
            if(null != all){
                size = Iterators.size(all);
            }
            //如果小药小于4
            if(size < 4){
                //如果没有大药就买
                match = region.wait("D:/software/sikulix/image/yaopin2.PNG",1);
                if(null == match){
                    //寻找商铺
                    match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                    if(null == match){
                        region.setX(799);
                        region.setY(581);
                        region.setW(361);
                        region.setH(305);
                        match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                        region.setX(0);
                        region.setY(0);
                        region.setW(1200);
                        region.setH(800);
                    }
                    match.click();
                    match = region.wait("D:/software/sikulix/image/yaopin3.PNG",1);
                    if(null == match){
                        match = region.wait("D:/software/sikulix/image/yaopin4.PNG",1);
                    }
                    match.click();
                    match = region.wait("D:/software/sikulix/image/yaopin2.PNG",1);
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
                }
            }
            //关闭包裹
            match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
            if(null != match){
                match.click();
            }
    }

}
