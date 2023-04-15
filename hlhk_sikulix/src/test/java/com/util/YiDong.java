package com.util;

import com.CongQiStart;
import org.sikuli.script.*;

public class YiDong {
   public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);
        ydck(region);
    }

    public static void ydck(Region region){
        try {
            Match xia1 = CongQiStart.tjReg.wait("D:/software/sikulix/cq/rw.PNG", 2);
            if(null != xia1){
                //移动文件到指定位置
                xia1.hover();
                Thread.sleep(500);
                //按下左键
                CongQiStart.tjReg.mouseDown(Button.LEFT);
                Match xia = CongQiStart.tjReg.wait("D:/software/sikulix/cq/dn.PNG", 2);
                Location location = xia.getTarget();
                location.setX(location.getX()+35);
                location.setY(location.getY()-30);
                //将鼠标指针移动到指定位置
                CongQiStart.tjReg.mouseMove(location);
                Thread.sleep(500);
                //松开左键
                CongQiStart.tjReg.mouseUp(Button.LEFT);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //移动F12到聊天栏
  /*  public static void yd(Region region){
       try {
           Match xia1 = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 2);
           if(null != xia1){
               xia1.setY(xia1.getY()-50);
               xia1.click();
               region.type(Key.F12);
               xia1 = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 2);
               if(null != xia1){
                   //移动文件到指定位置
                   Match match = region.wait("D:/software/sikulix/yd/f12.png", 5);
                   match.hover();
                   Thread.sleep(500);
                   //按下左键
                   region.mouseDown(Button.LEFT);

                   Match xia = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 2);
                   Location location = xia.getTarget();
                   location.setX(location.getX()+220);
                   location.setY(location.getY()+30);
                   //将鼠标指针移动到指定位置
                   region.mouseMove(location);
                   Thread.sleep(500);
                   //松开左键
                   region.mouseUp(Button.LEFT);
               }
               region.type(Key.F12);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }*/
}
