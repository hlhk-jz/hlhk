package com;
import org.sikuli.script.*;

/**
 * 案例当指定图片出现后，按 F6 然后 粘贴
 */
public class SikTest2 {
    public static void main(String[] args)throws Exception{
        boolean isTrue = true;
        Region region = new Region(0, 0,1920,1080);
        while (isTrue){
            //findText 方法只能检索单个数字和英文字母
            //Match match = region.findText("t");
            Match match = null;
            //没有找到图片会报错
            try {
                match = region.find("D:/m.png");
            } catch (FindFailed findFailed) {

            }
            /*Location target = match.getTarget();
            Thread.sleep(300);
            target.doubleClick();
            System.out.println(match);*/
            Thread.sleep(300);
            region.type(Key.F6);
            Thread.sleep(300);
            region.type("v",Key.CTRL );
            isTrue = false;
        }
    }
}
