package com;
import org.sikuli.script.*;

public class SikTest4 {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        //isValid 该方法判断创建的区域是否在屏幕中
       /* boolean valid = region.isValid();
        if(valid){
            System.out.println("包含在屏幕中！！！");
        }else {
            System.out.println("没有在屏幕中！！！！");
        }*/

       //设置没找到不报错
        region.setThrowException(false);
        Match match = region.find("D:/sikuliximage/m.png");

        if(null != match){
            //hover() 移动鼠标光标以将鼠标悬停在单击点上方
            //match.hover();

        }
    }
}
