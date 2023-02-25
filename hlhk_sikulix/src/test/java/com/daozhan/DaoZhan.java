package com.daozhan;

import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

/**道站*/
public class DaoZhan {
public static void main(String[] args)throws Exception{
    Region region = new Region(0, 0,1000,800);
    region.setThrowException(false);
    Settings.MinSimilarity = 0.8;
    while (true){
        Match wait = region.wait("D:/software/sikulix/image/shouhu.PNG", 5);
        if(null != wait){
            Thread.sleep(5000);
            region.type(Key.F6);
            Thread.sleep(500);
            region.type(Key.F6);
            Thread.sleep(500);
            region.type(Key.F5);
            Thread.sleep(300);
            region.type(Key.F3);
        }
    }
}
}
