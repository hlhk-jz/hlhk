package com.xinshou;
import com.util.BaoBao;
import com.util.CurrencyData;
import com.util.SikJZB;
import com.util.SikYaoPin;
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
        xsDaguai(region,match);
    }

    public static void xsDaguai(Region region,Match match) throws Exception {
        Match matchyd;
        int count = 0;
        //检查宝宝是否在线
        BaoBao.baobao(region);
        //如果教主不为空一直循环打
        while (null != match) {
            //合击
            if((count%6)==0){
                region.type(Key.F1);
                match.setY(match.getY()-10);
                match.rightClick();
            }else {
                match.setY(match.getY()+80);
                match.click();
                Thread.sleep(300);
                region.type(Key.F3);
            }
            System.out.println("循环打怪count：" + count);
            if (count > 150) {
                System.out.println("打怪超过指定次数结束循环");
                break;
            }
            //判断小退，锁定
            CurrencyData.isTrue(region,0);
            if((count%6)== 0 && count != 0){
                System.out.println("打怪捡装备开始");
                SikJZB.pickup();
                System.out.println("打怪捡装备开始");
                SikYaoPin.zhYaoPin(region);
            }

            SikJZB.gb(region);
            count++;
            if(count > 5){
                System.out.println("打怪大于指定次数，缩小地图~~~~~~");
                match = CurrencyData.sxRegion.wait(CurrencyData.xsJZ, 1);
                //防止人物重叠怪识别不出来再次查询
                if (null == match) {
                    region.setX(0);
                    region.setY(0);
                    region.setW(1200);
                    region.setH(800);
                    Settings.MinSimilarity = 0.8;
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 1);
                    matchyd.setY(matchyd.getY() - 377);
                    matchyd.setX(matchyd.getX() + 400);
                    matchyd.rightClick();
                    Settings.MinSimilarity = 0.7;
                    region.type(Key.F4);
                    match = CurrencyData.sxRegion.wait(CurrencyData.xsJZ, 1);
                }
            }else {
                match = region.wait(CurrencyData.xsJZ, 1);
                //防止人物重叠怪识别不出来再次查询
                if (null == match) {
                    region.setX(0);
                    region.setY(0);
                    region.setW(1200);
                    region.setH(800);
                    Settings.MinSimilarity = 0.8;
                    matchyd = region.wait("D:/software/sikulix/tulongdian/tldyd.PNG", 1);
                    matchyd.setY(matchyd.getY() - 377);
                    matchyd.setX(matchyd.getX() + 400);
                    matchyd.rightClick();
                    region.type(Key.F4);
                    Thread.sleep(300);
                    matchyd.rightClick();
                    Settings.MinSimilarity = 0.7;
                    region.type(Key.F4);
                    match = region.wait(CurrencyData.xsJZ, 1);
                }
            }
        }
    }
}
