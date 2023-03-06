package com;
import com.util.CurrencyData;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

//监听
public class MonitorStart {
    public static void main(String[] args)throws Exception{
        //左上宝宝血量位置区域
        Region region = new Region(0, 0,1000,1000);
        region.setThrowException(false);
        while (true){
            //检查是否被锁定
            bsd(region);
            //检查宝宝血量
            bbxl(region);
            //检查是否需要小退
            sw(region);
        }
    }

    public static void sw(Region region)throws Exception{
        Settings.MinSimilarity= 0.99;
        region.setX(0);
        region.setY(502);
        region.setW(317);
        region.setH(373);
        Match match = region.wait("D:/software/sikulix/image/sw.PNG", 2);
        if(null != match){
            System.out.println("检测到人物需要小退！！当前时间："+System.currentTimeMillis()/1000);
            //人物需要小退
            Thread.sleep(5000);
            match = region.wait("D:/software/sikulix/image/sw.PNG", 2);
            if(null != match){
                region.setX(659);
                region.setY(561);
                region.setW(255);
                region.setH(181);
                Settings.MinSimilarity= 0.8;
                match = region.wait("D:/software/sikulix/image/out.PNG", 2);
                if (null != match) {
                    region.setX(0);
                    region.setY(0);
                    region.setW(1200);
                    region.setH(800);
                    match.click();
                    match = region.wait("D:/software/sikulix/image/qdtc.PNG", 6);
                    match.click();
                    Thread.sleep(5000);
                    match = region.wait("D:/software/sikulix/image/ksjr.PNG", 6);
                    match.click();
                    Thread.sleep(5000);
                    match = region.wait("D:/software/sikulix/image/qdjr.PNG", 5);
                    if(null == match){
                        match = region.wait("D:/software/sikulix/image/qdjr1.PNG", 2);
                    }
                    match.click();
                    Thread.sleep(2000);
                }
            }
        }
    }

    public static void bbxl(Region region)throws Exception{
        Match match = null;
        Settings.MinSimilarity= 0.95;
        region.setX(1);
        region.setY(0);
        region.setW(211);
        region.setH(60);
        match = region.wait("D:/software/sikulix/image/xl.PNG",2);
        if(null != match){
            System.out.println("宝宝血量减少！！！当前时间："+System.currentTimeMillis());
            Settings.MinSimilarity= 0.7;
            region.setX(305);
            region.setY(504);
            region.setW(438);
            region.setH(217);
            match = region.wait(CurrencyData.zblSjs,0.5);
            if(null == match){
                match = region.wait(CurrencyData.zblSjs,0.5);
            }
            if(null != match){
                match.doubleClick();
                //跟随
                region.type(Key.F1);

                match = region.wait("D:/software/sikulix/image/sw.PNG", 2);
                if(null != match){
                    //人物需要小退，将宝宝召回
                    region.type(Key.F5);
                }
            }else {
                //如果没找到随机石，宝宝召回
                region.type(Key.F5);
            }
            Thread.sleep(5000);
        }
    }

    private static void bsd(Region region) {
        Settings.MinSimilarity=0.85;
        region.setX(133);
        region.setY(438);
        region.setW(690);
        region.setH(391);
        try {
            Match match = region.wait(CurrencyData.bsd,2);
            if(null != match){
                System.out.println("被锁定！！！当前时间："+System.currentTimeMillis()/1000);
                Match match2 = region.wait("D:/software/sikulix/image/shitou.PNG",0.5);
                if(null == match2){
                    match2 = region.wait("D:/software/sikulix/image/shitou.PNG",1);
                }
                if(null != match2){
                    match2.doubleClick();
                    Thread.sleep(300);
                    match2.doubleClick();
                    Thread.sleep(300);
                    match2.doubleClick();
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(300);
                    region.type(Key.F1);
                    Thread.sleep(4000);
                }else {
                    //召回
                    Thread.sleep(300);
                    region.type(Key.F5);
                    Thread.sleep(300);
                    region.type(Key.F5);
                    Thread.sleep(300);
                    region.type(Key.F5);
                    Thread.sleep(300);
                    region.type(Key.F5);
                    Thread.sleep(300);
                    match2 = region.wait("D:/software/sikulix/image/shitou.PNG",0.5);
                    if(null == match2){
                        match2 = region.wait("D:/software/sikulix/image/shitou.PNG",1);
                    }
                    if(null != match2){
                        match2.doubleClick();
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
