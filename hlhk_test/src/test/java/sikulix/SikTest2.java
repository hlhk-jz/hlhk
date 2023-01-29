package sikulix;

import org.sikuli.script.*;

public class SikTest2 {
    public static void main(String[] args)throws Exception{
        boolean isTrue = true;
        //案例1 循环监听是否有 m.png 图片出现，如果出现进行双击并退出循环
        //案例2 循环监听是否有 m.png 图片出现，如果出现按 F6 并 粘贴，之后退出循环
        while (isTrue){
            Region region = new Region(0, 0,1920,1080);
            //findText 方法只能检索单个数字和英文字母
            //Match match = region.findText("t");
            Match match = null;
            try {
                //没有找到图片会报错
                match = region.find("D:/m.png");
                /*Location target = match.getTarget();
                Thread.sleep(300);
                target.doubleClick();
                System.out.println(match);*/
                Thread.sleep(300);
                region.type(Key.F6);
                Thread.sleep(300);
                region.type("v",Key.CTRL );
                isTrue = false;
            } catch (FindFailed findFailed) {
                //不打印错误信息
                //findFailed.printStackTrace();
            }
        }

    }
}
