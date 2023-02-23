package cesi;

import org.sikuli.basics.Settings;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class SikTest {
    /**
     * 移动文件到指定位置
     */
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 601,168,244);
        region.setThrowException(false);
        Settings.MinSimilarity=0.8;
        region.setX(659);
        region.setY(561);
        region.setW(255);
        region.setH(181);
        Match wait = region.wait("D:/software/sikulix/image/out.PNG", 0.8);
        region.setX(0);
        region.setY(0);
        region.setW(1000);
        region.setH(800);
        if(null != wait){
            System.out.println("===================");
            wait.click();
            wait = region.wait("D:/software/sikulix/image/qdtc.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/ksjr.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/qdjr.PNG", 0.8);
            wait.click();
        }else {
            System.out.println("!!!!!!!!!!!!!!!!!!!");
        }

        //寻找补给
      /*  Match match = region.wait("D:/software/sikulix/image/bj.PNG", 2);
        if (null == match){
            match = region.wait("D:/software/sikulix/image/bj2.PNG", 2);
        }
        if(null != match){
            match.hover();
        }*/

       /* Match match = region.wait("D:/sikuliximage/yidong.png", 2);
        match.hover();
        Thread.sleep(500);
        //按下左键
        region.mouseDown(Button.LEFT);
        Location location = new Location(200, 200);
        //将鼠标指针移动到指定位置
        region.mouseMove(location);
        Thread.sleep(500);
        //松开左键
        region.mouseUp(Button.LEFT);*/
    }
}
