package cesi;
import com.google.common.collect.Iterators;
import com.tld.ATuLongDianStart;
import com.util.CurrencyData;
import com.util.SikJZB;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.sikuli.script.Button;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class SikTest {

    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1200,800);
        region.setThrowException(false);

       /* csDaGuai(region);
*/
        Iterator<Match> all = CurrencyData.kgRegion.findAll("D:/software/sikulix/xinshou/kg.PNG");
        System.out.println(Iterators.size(all));

   /*     Match match = region.wait("D:/software/sikulix/huishou/rjb.PNG",1);
        if(null != match){
            match = region.wait("D:/software/sikulix/huishou/rjb1.PNG",1);
            match.hover();
        }
*/
       /* Thread.sleep(300);
        Iterator<Match> all = region.findAll("D:/software/sikulix/xinshou/kg.PNG");
        if(null != all){
            int size = Iterators.size(all);
            System.out.println("=== "+size);
        }
*/
        //寻找界面下面菜单，调整鼠标位置人物左边移动
       // Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        //上
        /*match.setY(match.getY()-500);
        match.setX(match.getX()-400);
        match.hover();*/

        //下
       /* match.setY(match.getY()-80);
        match.setX(match.getX()-400);
        match.hover();*/
       /*for (int sdCount=0;sdCount<9;sdCount++){
           Match bgMatch = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
           if(1==sdCount || 5== sdCount){
               bgMatch.setY(bgMatch.getY()-500);
               bgMatch.setX(bgMatch.getX()-400);
               bgMatch.rightClick();
           }else
           if(2==sdCount || 6== sdCount){
               bgMatch.setY(bgMatch.getY()-80);
               bgMatch.setX(bgMatch.getX()-400);
               bgMatch.rightClick();
           }else
           if(3==sdCount || 7== sdCount){
               bgMatch.setY(bgMatch.getY()-300);
               bgMatch.setX(bgMatch.getX()-600);
               bgMatch.rightClick();
           }else
           if(4==sdCount || 8== sdCount){
               bgMatch.setY(bgMatch.getY()-300);
               bgMatch.setX(bgMatch.getX()-150);
               bgMatch.rightClick();
           }else {}

       }*/

        //右
        /*match.setY(match.getY()-300);
        match.setX(match.getX()-150);
        match.hover();*/



        /*Settings.MinSimilarity = 0.65;
        Match match2 = jzbRegion.wait(CurrencyData.zblSjs,1);
        if(null == match2){
            match2 = jzbRegion.wait(CurrencyData.zblSjs,1);
        }*/
       /* Match  match = region.wait("D:/software/sikulix/image/baoguo.PNG",1);
        match.setY(match.getY()-300);
        match.setX(match.getX()-400);
        match.hover();*/


       /* Match bgMathc = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        bgMathc.setY(bgMathc.getY()-100);
        bgMathc.setX(bgMathc.getX()-230);
        bgMathc.hover();
        bgMathc.setY(bgMathc.getY()-350);
        bgMathc.hover();
*/
       /* Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        match.setY(match.getY()-100);
        match.setX(match.getX()-230);
        if(null != match){
            match.hover();
        }*/


     /*   Settings.MinSimilarity= 0.8;
        Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
        matchyd.setY(matchyd.getY()-377);
        matchyd.hover();*/

/*        Match matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG",1);
if(null != matchyd){
    System.out.println("1111111");
}*/
        /*Settings.MinSimilarity=0.9;
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
*/


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

    private static void csDaGuai(Region region) {
        try {
            Region hjRegion = new Region(791, 644,88,165);
            hjRegion.setThrowException(false);
            Match match = region.wait(CurrencyData.tldJZ, 1);
            while (null != match){
                match.setY(match.getY()+80);
                match.click();
                //查看合击是否已满
                Settings.MinSimilarity = 0.9;
                Match hjMatch = hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 1);
                if(null != hjMatch){
                    System.out.println("释放合击！！！！");
                    region.type(Key.F3);
                    //查看是否释放成功
                    Match cgMatch = hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 2);
                    if(null != cgMatch){
                        System.out.println("释放合击成功~~~~~");
                        //释放合击成功后，只打当前怪
                        while (true){
                            hjMatch = hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 1);
                            if(null != hjMatch){
                                //释放合击
                                region.type(Key.F3);
                                cgMatch = hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 2);
                                if(null == cgMatch){
                                    System.out.println("当前怪打完，查找下一个！！！");
                                    break;
                                }
                            }
                        }
                    }
                }
                Settings.MinSimilarity = 0.7;
                match = region.wait(CurrencyData.tldJZ, 3);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
