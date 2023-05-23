package wd;
import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class KS {
    public static void main(String[] args){
        Region region = new Region(1800, 0);
        try {
            Settings.MinSimilarity = 0.9;
            while (true){
                Match match = KSData.region1.wait(KSData.STR, 2);
                if(null != match){
                    Thread.sleep(300);
                    match.click();
                    Thread.sleep(300);
                    region.hover();
                    Thread.sleep(300);
                    match = KSData.region1.wait(KSData.STR, 2);
                    Thread.sleep(300);
                    match.click();
                }

                match = KSData.region2.wait(KSData.STR, 2);
                if(null != match){
                    Thread.sleep(300);
                    match.click();
                    Thread.sleep(300);
                    region.hover();
                    Thread.sleep(300);
                    match = KSData.region2.wait(KSData.STR, 2);
                    Thread.sleep(300);
                    match.click();
                }

                match = KSData.region3.wait(KSData.STR, 2);
                if(null != match){
                    Thread.sleep(300);
                    match.click();
                    Thread.sleep(300);
                    region.hover();
                    Thread.sleep(300);
                    match = KSData.region3.wait(KSData.STR, 2);
                    Thread.sleep(300);
                    match.click();
                }

                match = KSData.region4.wait(KSData.STR, 2);
                if(null != match){
                    Thread.sleep(300);
                    match.click();
                    Thread.sleep(300);
                    region.hover();
                    Thread.sleep(300);
                    match = KSData.region4.wait(KSData.STR, 2);
                    Thread.sleep(300);
                    match.click();
                }

                match = KSData.region5.wait(KSData.STR, 2);
                if(null != match){
                    Thread.sleep(300);
                    match.click();
                    Thread.sleep(300);
                    region.hover();
                    Thread.sleep(300);
                    match = KSData.region5.wait(KSData.STR, 2);
                    Thread.sleep(300);
                    match.click();
                }
                System.out.println("执行中！！！！！！");
                Thread.sleep(120000);
            }
        }catch (Exception e ){
           e.printStackTrace();
        }
    }
}
