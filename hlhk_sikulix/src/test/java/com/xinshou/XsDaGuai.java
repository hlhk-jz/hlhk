package com.xinshou;
import com.util.*;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
//新手打怪,战道
public class XsDaGuai {

    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0, 1920, 1080);
        region.setThrowException(false);
        Match match = region.wait(CurrencyData.xsJZ, 1);
        xsDaguai(region);
    }

    public static void xsDaguai(Region region) throws Exception {
        int count = 0;
        int hlCount = 1;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        region.type(Key.F1);
        Match match = region.wait(CurrencyData.xsJZ, 1);
        while (null != match){
            match.setY(match.getY()+80);
            match.click();
            Thread.sleep(500);
            //释放合击
            SikJZB.gb(region);
            region.type(Key.F3);
            Settings.MinSimilarity = 0.99;
            Thread.sleep(800);
            //查看是否释放成功
            Match cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 1);
            if(null != cgMatch){
                //再次判断合击
                cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 12);
                if(null != cgMatch){
                    region.type(Key.F3);
                    Thread.sleep(800);
                    cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 1);
                    if(null != cgMatch){
                        System.out.println("释放合击成功~~~~~");
                        while (true){
                            //判断是否锁定
                            CurrencyData.isTrue(region,0);
                            BaoBao.baobao(region);
                            Settings.MinSimilarity = 0.99;
                            //查看合击是否满了
                            cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj1.PNG", 1);
                            if(null != cgMatch){
                                //释放合击
                                Thread.sleep(800);
                                region.type(Key.F3);
                                Thread.sleep(300);
                                cgMatch = CurrencyData.hjRegion.wait("D:/software/sikulix/heji/hj2.PNG", 2);
                                if(null == cgMatch){
                                    System.out.println("当前怪打完，查找下一个！！！");
                                    //捡装备
                                    SikJZB.pickup();
                                    region.type(Key.F1);
                                    SikYaoPin.zhYaoPin(region);
                                    Thread.sleep(1500);
                                    count = 1;
                                    break;
                                }
                            }
                            if(hlCount > 50){
                                //防止没有火龙之心
                                System.out.println("打怪期间检查到宝宝没有火龙之心！！！！！！！！！！！！！！");
                                Settings.MinSimilarity = 0.7;
                                Thread.sleep(500);
                                HLZX.hlzx(region);
                                Settings.MinSimilarity = 0.99;
                                Thread.sleep(500);
                            }
                            hlCount ++;
                        }
                        hlCount = 1;
                    }
                }
            }
            count++;
            Settings.MinSimilarity = 0.7;
            //判断是否锁定
            CurrencyData.isTrue(region,0);
            if (count > 2) {
                System.out.println("打怪大于指定次数结束本次循环！！！！！！");
                break;
            }else {
                match = CurrencyData.xszgRegion.wait(CurrencyData.xsJZ, 2);
            }
        }
    }
}
