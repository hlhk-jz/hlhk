package com.dz;

import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//道战
public class DaoZhan {
    public static void main(String[] args)throws Exception{
        Region region = new Region(139, 609,728,264);
        region.setThrowException(false);
        while (true){
            Thread.sleep(8000);
            //寻找锁定
            Match match = region.wait("D:/software/sikulix/image/suoding.PNG",5);
            if(null != match){
                //无极真气
                region.type(Key.F5);
                Thread.sleep(300);
                //合击
                region.type(Key.F4);
            }
        }

    }
}
