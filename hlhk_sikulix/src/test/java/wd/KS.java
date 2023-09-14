package wd;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
public class KS {
    public static void main(String[] args){
        try {
            Region region = new Region(1744, 54,99,102);
            while (true){
                try {
                    Match wait = KSData.regionData.wait(KSData.DATA, 10);
                    if(null != wait){
                        Match match = KSData.region1.wait(KSData.DATA, 0.3);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region1.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region2.wait(KSData.DATA, 0.3);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region2.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region3.wait(KSData.DATA, 0.3);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region3.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region4.wait(KSData.DATA, 0.3);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region4.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }

                        match = KSData.region5.wait(KSData.DATA, 0.3);
                        if(null != match){
                            match.click();
                            Thread.sleep(300);
                            region.hover();
                            match = KSData.region5.wait(KSData.DATA, 0.5);
                            match.setY(match.getY()+25);
                            match.click();
                        }
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
