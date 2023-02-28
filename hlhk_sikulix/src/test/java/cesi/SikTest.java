package cesi;
import com.google.common.collect.Iterators;
import com.tld.ATuLongDianStart;
import com.util.CurrencyData;
import com.xinshou.XSHandler;
import com.xinshou.XinShouDianStart;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.sikuli.script.Button;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class SikTest {

    public static void main(String[] args)throws Exception{
        Region region = new Region(305, 504,438,217);
        region.setThrowException(false);

        Settings.MinSimilarity=0.9;
        region.setX(0);
        region.setY(601);
        region.setW(168);
        region.setH(244);
        Match wait = region.wait("D:/software/sikulix/image/tldimg.PNG", 0.5);
        Settings.MinSimilarity=0.7;
        region.setX(0);
        region.setY(0);
        region.setW(1000);
        region.setH(800);
        if(null == wait){
            System.out.println("没在屠龙殿！！！！！");
        }else {
            System.out.println("在屠龙殿");
        }



       /* Match match = region.wait(CurrencyData.zblSjs,0.5);
        if(null == match){
            match = region.wait(CurrencyData.zblSjs,0.5);
        }
        if(null != match){
            match.doubleClick();
        }*/
     /*   Settings.MinSimilarity= 0.95;
        while (true){
            Match matchyd = region.wait("D:/software/sikulix/image/xl.PNG",1);
            if(null != matchyd){
                System.out.println("血量！！！！！！"+System.currentTimeMillis());
                Thread.sleep(3000);
            }
        }*/



      /*  if(true){
            Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
            matchyd.setY(matchyd.getY()-150);
            matchyd.setX(matchyd.getX()+180);
            matchyd.hover();
           *//* if(true){
                //跟随寻找教主
                region.type(Key.F1);
                matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-377);
                matchyd.rightClick();
            }*//*
        }*/

        /*Match matchyd;
        if(true){
            //右下
            matchyd= region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
            matchyd.setY(matchyd.getY()-100);
            matchyd.setX(matchyd.getX()+400);
            matchyd.rightClick();
            Thread.sleep(600);
            matchyd.rightClick();
            Thread.sleep(600);
            matchyd.rightClick();
            Thread.sleep(300);
            matchyd.rightClick();
            Thread.sleep(300);
            //寻找教主
            //anyList = region.findAnyList(CurrencyData.jzList());
            Thread.sleep(1000);
            if(true){
                //左上
                matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
                matchyd.setY(matchyd.getY()-500);
                matchyd.setX(matchyd.getX()-80);
                matchyd.rightClick();
                Thread.sleep(600);
                matchyd.rightClick();
                Thread.sleep(600);
                matchyd.rightClick();
                Thread.sleep(300);
                matchyd.rightClick();
                Thread.sleep(300);
                matchyd.rightClick();
                Thread.sleep(600);
                matchyd.rightClick();
                Thread.sleep(600);
                matchyd.rightClick();
                Thread.sleep(300);
                matchyd.rightClick();
                Thread.sleep(300);
                matchyd.rightClick();
                Thread.sleep(600);
                matchyd.rightClick();
                Thread.sleep(300);
                matchyd.rightClick();
                Thread.sleep(300);
            }
        }
*/



        //寻找商铺
      /*  Match match = region.wait("D:/software/sikulix/image/pu.PNG",1);
        match.hover();*/


        /*Match bgMathc = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        bgMathc.setY(bgMathc.getY()-300);
        Thread.sleep(300);
        bgMathc.hover();*/

       /* Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
        matchyd.setY(matchyd.getY()-377);
        matchyd.hover();*/
       /* boolean isTrue = true;
        Settings.MinSimilarity=0.99;
        Match wait = region.wait("D:/software/sikulix/image/youxia.PNG", 0.5);
        if(null != wait){
            System.out.println("右下");
            isTrue = false;
        }
        if(isTrue){
            wait = region.wait("D:/software/sikulix/image/zuoshang.PNG", 0.5);
            if(null != wait){
                System.out.println("左上");
                isTrue = false;
            }
        }
        if(isTrue){
            wait = region.wait("D:/software/sikulix/image/zuoxia.PNG", 0.5);
            if(null != wait){
                System.out.println("左下");
                isTrue = false;
            }
        }
*/
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
       /* Match xiasss = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 2);
        xiasss.setY(xiasss.getY()-50);
        xiasss.click();
        region.type(Key.F12);


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
