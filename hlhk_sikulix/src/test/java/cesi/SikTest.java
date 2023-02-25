package cesi;
import com.google.common.collect.Iterators;
import com.util.CurrencyData;
import com.xinshou.XSHandler;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class SikTest {

    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);




        /*Match match2 = region.wait(CurrencyData.zblSjs,1);
        match2.hover();*/

       /* Iterator<Match> all = region.findAll("D:/software/sikulix/tulongdian/shitou.PNG");
        Thread.sleep(1000);
        if(null != all){
            System.out.println("数量："+ Iterators.size(all));
        }*/
      /*  Match match = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
        match.setY(match.getY()-150);
        match.setX(match.getX()+160);
        match.hover();*/
        /*Robot robot = new Robot();
        //模拟按下D
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_Q);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyPress(KeyEvent.VK_E);*/


       /* Settings.MinSimilarity=0.8;
        region.setX(659);
        region.setY(561);
        region.setW(255);
        region.setH(181);
        Match wait = region.wait("D:/software/sikulix/image/out.PNG", 0.8);
        region.setX(0);
        region.setY(0);
        region.setW(1000);
        region.setH(800);
        if(null != wait){
            System.out.println("===================");
            wait.click();
            wait = region.wait("D:/software/sikulix/image/qdtc.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/ksjr.PNG", 0.8);
            wait.click();
            Thread.sleep(5000);
            wait = region.wait("D:/software/sikulix/image/qdjr.PNG", 0.8);
            wait.click();
        }else {
            System.out.println("!!!!!!!!!!!!!!!!!!!");
        }*/

        //寻找补给
      /*  Match match = region.wait("D:/software/sikulix/image/bj.PNG", 2);
        if (null == match){
            match = region.wait("D:/software/sikulix/image/bj2.PNG", 2);
        }
        if(null != match){
            match.hover();
        }*/

      //移动文件到指定位置
       /* Match match = region.wait("D:/sikuliximage/yidong.png", 2);
        match.hover();
        Thread.sleep(500);
        //按下左键
        region.mouseDown(Button.LEFT);
        Location location = new Location(200, 200);
        //将鼠标指针移动到指定位置
        region.mouseMove(location);
        Thread.sleep(500);
        //松开左键
        region.mouseUp(Button.LEFT);*/
    }


    public static void daGuai(Region region)throws Exception{
        int count = 0;
        int xzJz = 1;
        Region bsdReg = new Region(139,609,728,264);
        Match match = null;
        //锁定
        while (null == match){
            count ++;
           //如果找不到教主了一直寻找
            match = region.wait(CurrencyData.xsJZ,0.5);
            while (null == match){
                xzJz++;
                match = region.wait(CurrencyData.xsJZ,0.5);
                if(xzJz == 10){
                    XSHandler.show(region);
                }
            }

            if((count%2)==0){
                match.setY(match.getY()-30);
            }else {
                match.setY(match.getY()+80);
            }
            match.hover();
            //锁定
            region.type(Key.F2);
            //右键激活教主
            match.rightClick();
            Thread.sleep(300);
            match.rightClick();
            //寻找英雄锁定
            match = region.wait(CurrencyData.ztsd,0.5);
            //判断是不是有门
            if((count > 5) && null == match){

            }
        }
    }
}
