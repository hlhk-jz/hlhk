package cn.test.win;
import java.awt.*;
import java.awt.event.KeyEvent;

//获取屏幕鼠标位置
public class Test1 {
    public static void main(String[] args)throws Exception {
        Point p = MouseInfo.getPointerInfo().getLocation();
        System.out.println("鼠标当前位置："+p.getX()+","+p.getY());
    }
}
