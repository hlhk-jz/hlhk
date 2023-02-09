package com;
import org.sikuli.script.*;
public class SikTest8 {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        Match wait = region.wait("D:/sikuliximage/jar.png", 10);
        //查看文件位置
        Location target = wait.getTarget();
        System.out.println(target.x);
        System.out.println(target.y);
        target.setY(264);
        target.hover();
    }
}
