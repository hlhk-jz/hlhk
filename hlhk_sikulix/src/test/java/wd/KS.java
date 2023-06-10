package wd;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KS {
    public static void main(String[] args){
        try {
            Region region1 = new Region(1678, 26,242,255);
            Match region = region1.wait(KSData.sikpng, 2);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Settings.MinSimilarity = 0.9;
            while (true){
                try {
                    Match wait = KSData.regionData.wait(KSData.DATA, 10);
                    if(null != wait){
                        Match match = KSData.region1.wait(KSData.STR, 1);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region1.wait(KSData.STR, 1);
                            match.click();
                        }

                        match = KSData.region2.wait(KSData.STR, 1);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region2.wait(KSData.STR, 1);
                            match.click();
                        }

                        match = KSData.region3.wait(KSData.STR, 1);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region3.wait(KSData.STR, 1);
                            match.click();
                        }

                        match = KSData.region4.wait(KSData.STR, 1);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region4.wait(KSData.STR, 1);
                            match.click();
                        }

                        match = KSData.region5.wait(KSData.STR, 1);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region5.wait(KSData.STR, 1);
                            match.click();
                        }
                        System.out.println("执行时间："+format.format(new Date()));
                    }
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
