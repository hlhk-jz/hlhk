package wd;
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
            while (true){
                try {
                    Match wait = KSData.regionData.wait(KSData.DATA, 10);
                    if(null != wait){
                        Match match = KSData.region1.wait(KSData.DATA, 0.5);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region1.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region2.wait(KSData.DATA, 0.5);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region2.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region3.wait(KSData.DATA, 0.5);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region3.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region4.wait(KSData.DATA, 0.5);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region4.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region5.wait(KSData.DATA, 0.5);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region5.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }
                        System.out.println("执行时间："+format.format(new Date()));
                        region.hover();
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
