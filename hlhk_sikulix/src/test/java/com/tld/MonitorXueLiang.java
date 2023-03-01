package com.tld;
import com.util.CurrencyData;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

// 检查宝宝血量和是否被锁定
public class MonitorXueLiang {
    public static void main(String[] args)throws Exception{
        //左上宝宝血量位置区域
        Region region = new Region(133, 438,690,391);
        region.setThrowException(false);
        while (true){
            //检查是否被锁定
            bsd(region);
            //检查宝宝血量
            bbxl(region);
        }
    }
    public static void bbxl(Region region)throws Exception{
        Match match = null;
        Settings.MinSimilarity= 0.95;
        region.setX(1);
        region.setY(0);
        region.setW(211);
        region.setH(60);
        match = region.wait("D:/software/sikulix/image/xl.PNG",1);
        if(null != match){
            System.out.println("血量减少！！！！！！"+System.currentTimeMillis());
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
            }else {
                //如果没找到随机石，宝宝召回
                region.type(Key.F8);
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
            Match match = region.find(CurrencyData.bsd);
            if(null != match){
                System.out.println("被锁定！！！！！！");
                Match match2 = region.wait("D:/software/sikulix/image/shitou.PNG",0.5);
                if(null == match2){
                    match2 = region.wait("D:/software/sikulix/image/shitou.PNG",1);
                }
                match2.doubleClick();
                Thread.sleep(300);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
