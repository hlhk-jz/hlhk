package com.util;

import com.tld.ATuLongDianStart;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

/**
 * 退出
 */
public class TuiChu {
  /*  public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        tuiChu(region);
    }*/

    public static void tuiChu(Region region) throws Exception {
        region.setX(659);
        region.setY(561);
        region.setW(255);
        region.setH(181);
        Match wait = region.wait("D:/software/sikulix/image/out.PNG", 0.8);
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(800);
        if (null != wait) {
            wait.click();
            wait = region.wait("D:/software/sikulix/image/qdtc.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/ksjr.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/qdjr.PNG", 0.8);
            wait.click();
            Thread.sleep(2000);
            ATuLongDianStart.tld(region);
        }
    }
}
