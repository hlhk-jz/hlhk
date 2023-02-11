package com;
import org.sikuli.script.*;

public class SikJZB {
  /*  public static void main(String[] args)throws Exception{
        pickup();
    }*/

    public static void pickup()throws Exception{
        for (int i = 1;i<2;i++){
            //星王
            jzb("D:/software/sikulix/zhuangbei/xw.PNG");
            //强化
            jzb("D:/software/sikulix/zhuangbei/qh.PNG");
            //混世
            jzb("D:/software/sikulix/zhuangbei/hs.PNG");
            //开天
            jzb("D:/software/sikulix/zhuangbei/kt.PNG");
            //圣魔
            jzb("D:/software/sikulix/zhuangbei/sm.PNG");
            //太极
            jzb("D:/software/sikulix/zhuangbei/tj.PNG");
            jzb("D:/software/sikulix/zhuangbei/tj2.PNG");
            //真魂
            jzb("D:/software/sikulix/zhuangbei/zh.PNG");
            //战神
            jzb("D:/software/sikulix/zhuangbei/zs.PNG");
            //震天
            jzb("D:/software/sikulix/zhuangbei/zt.PNG");
        }
    }

    private static void jzb(String target)throws Exception {
        Match matchGb = null;
        Region region = new Region(0, 0,1200,600);
        region.setThrowException(false);
        Match match = region.find(target);
        Thread.sleep(500);
        if(null != match){
            while (null != match){
                Location location = match.getTarget();
                location.setY(location.getY()+5);
                location.click();
                Thread.sleep(800);
                location.setY(500);
                location.hover();
                match = region.find(target);
                Thread.sleep(500);
                matchGb = region.find("D:/software/sikulix/image/gb.NPG");
                Thread.sleep(500);
                if(null != matchGb){
                    matchGb.click();
                }
            }
        }
    }
}
