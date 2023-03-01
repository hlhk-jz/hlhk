package com.tld;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

//检查是否需要小退
public class SwController {
    public static void main(String[] args)throws Exception{
        //左左下血量位置区域
        Region region = new Region(0, 502,317,373);
        region.setThrowException(false);
        Match tcMatch = null;
        Settings.MinSimilarity= 0.99;
        while (true){
            tcMatch = region.wait("D:/software/sikulix/image/sw.PNG", 2);
            if(null != tcMatch){
                System.out.println("检测到人物需要小退！！当前时间："+System.currentTimeMillis()/1000);
                //人物需要小退
                Thread.sleep(2000);
                region.setX(659);
                region.setY(561);
                region.setW(255);
                region.setH(181);
                Settings.MinSimilarity= 0.8;
                tcMatch = region.wait("D:/software/sikulix/image/out.PNG", 2);
                if (null != tcMatch) {
                    region.setX(0);
                    region.setY(0);
                    region.setW(1200);
                    region.setH(800);
                    tcMatch.click();
                    tcMatch = region.wait("D:/software/sikulix/image/qdtc.PNG", 6);
                    tcMatch.click();
                    Thread.sleep(5000);
                    tcMatch = region.wait("D:/software/sikulix/image/ksjr.PNG", 6);
                    tcMatch.click();
                    Thread.sleep(5000);
                    tcMatch = region.wait("D:/software/sikulix/image/qdjr.PNG", 6);
                    tcMatch.click();
                    Thread.sleep(2000);
                }
                Settings.MinSimilarity= 0.99;
                region.setX(0);
                region.setY(502);
                region.setW(317);
                region.setH(373);
            }
            Thread.sleep(5000);
        }
    }
}
