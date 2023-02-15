package com;

import com.google.common.collect.Iterators;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.Iterator;

/**
 * 检查药品
 */

public class SikYaoPin {
  /*  public static void main(String[] args)throws Exception{
       yaoPin();
    }*/
    public static void yaoPin() throws Exception{
        Match match = null;
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

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
                match = region.wait("D:/software/sikulix/image/pu.PNG",1);
                match.click();
                match = region.wait("D:/software/sikulix/image/yaopin3.PNG",1);
                if(null == match){
                    match = region.wait("D:/software/sikulix/image/yaopin4.PNG",1);
                }
                match.click();
                match = region.wait("D:/software/sikulix/image/yaopin2.PNG",1);
                match.click();
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
        //关闭物品栏
        match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
        if(null != match){
            match.click();
        }
    }

}
