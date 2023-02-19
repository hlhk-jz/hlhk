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
            Thread.sleep(3000);
            //寻找守护
            Match wait = region.wait("D:/software/sikulix/image/shouhu.PNG", 3);
            if(null != wait){
                Thread.sleep(1000);
                //无极真气
                Thread.sleep(200);
                region.type(Key.F5);
                //施毒术
    /*    region.type(Key.F2);
        Thread.sleep(2000);
        region.type(Key.F2);
        Thread.sleep(2000);*/
                //锁定
                region.type(Key.F3);
                //region.wait("D:/software/sikulix/image/suoding.PNG",0.6);
                Thread.sleep(200);
                //合击
                region.type(Key.F4);
            }
        }

    }
}
