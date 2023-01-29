package com;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
/**
 *  设置setThrowException 为 false ，找不到对应图片也不会报错
 */
public class SikTest3 {
    public static void main(String[] args)throws Exception{
        boolean isTrue = true;
        Region region = new Region(0, 0,1920,1080);
        //如果设置该值为 false，即使找不到对应图片也不会报错，但是返回的 match 为 null，需要判断处理
        region.setThrowException(false);
        while (isTrue){
            Match match = region.find("D:/m.png");
            if(null != match){
                Thread.sleep(300);
                region.type(Key.F6);
                Thread.sleep(300);
                region.type("v",Key.CTRL );
                isTrue = false;
            }
        }
    }
}
