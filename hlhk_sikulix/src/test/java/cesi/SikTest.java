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
        Match wait = region.wait("D:/software/sikulix/image/mzs.PNG", 0.5);
        if(null != wait){
            System.out.println("===================");
            wait.hover();
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
