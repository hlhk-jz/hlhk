package com;

import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class TuLongDian {
    public static void main(String[] args){
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        try {
            tld(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tld(Region region)throws Exception{
        Match match = null;
        match = region.find("D:/software/sikulix/tulongdian/tld.PNG");
        Thread.sleep(300);
     /*   if(null == match){
            match = region.find("D:/software/sikulix/image/hc.PNG");
            Thread.sleep(300);
            match.doubleClick();
        }
        int x = 1;

        while (null == match){
            if((x%3)==0){
                match = region.find("D:/software/sikulix/image/hc.PNG");
                Thread.sleep(300);
                match.doubleClick();
            }
            match = region.find("D:/software/sikulix/image/init.PNG");
            Thread.sleep(500);
            Location target = match.getTarget();
            System.out.println("x="+target.getX()+",y="+target.getY());
            target.setY(target.getY()-200);
            target.setX(target.getX()-250);
            target.rightClick();
            match = region.find("D:/software/sikulix/image/fuli.PNG");
            Thread.sleep(500);
            x++;
        }*/
        match.click();

        //寻找进入
        match = region.find("D:/software/sikulix/tulongdian/tldb.PNG");
        Thread.sleep(600);
        if(null == match){
            match = region.find("D:/software/sikulix/tulongdian/tldb.PNG");
        }
        //我要进入
        match.click();
        SikHandler.show(region);
    }
}
