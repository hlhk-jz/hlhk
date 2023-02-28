package com.tld;
import com.util.CurrencyData;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

// 检查宝宝血量
public class MonitorXueLiang {
    public static void main(String[] args)throws Exception{
        //左上宝宝血量位置区域
        Region region = new Region(1, 0,211,60);
        region.setThrowException(false);
        Settings.MinSimilarity= 0.95;
        Match match = null;
        while (true){
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
                Settings.MinSimilarity= 0.95;
                region.setX(1);
                region.setY(0);
                region.setW(211);
                region.setH(60);
            }
        }

    }
}
