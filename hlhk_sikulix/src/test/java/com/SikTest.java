package com;

import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

/**
 * 移动文件到指定位置
 */
public class SikTest {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,500,1080);
        region.setThrowException(false);

        Match match = region.wait("D:/sikuliximage/yidong.png", 2);
        match.hover();
        Thread.sleep(500);
        //按下左键
        region.mouseDown(Button.LEFT);
        Location location = new Location(200, 200);
        //将鼠标指针移动到指定位置
        region.mouseMove(location);
        Thread.sleep(500);
        //松开左键
        region.mouseUp(Button.LEFT);
    }
}
