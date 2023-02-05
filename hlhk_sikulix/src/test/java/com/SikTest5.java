package com;

import org.sikuli.script.*;
//f7  f8没用
public class SikTest5 {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        while (true){
            Match match = region.find("D:/software/sikulix/image/shouhu.PNG");
            if(null != match){
                System.out.println("出现！！！！！");
                Thread.sleep(500);
                region.type(Key.F7);
                Thread.sleep(500);
                region.type(Key.F8);
            }
        }
    }
}
