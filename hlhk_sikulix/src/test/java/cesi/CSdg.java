package cesi;

import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

//测试打怪
public class CSdg {
    public static Region sd = new Region(139, 609,728,264);

    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);
        bsd(region);
    }

    public static void bsd(Region region){
        try {
            while (true){
                Match wait = region.wait("D:/software/sikulix/cs/bsd.PNG");
                if(null != wait){
                    Match match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
                    if(null == match2){
                        match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",1);
                    }
                    match2.doubleClick();
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void daGuai(Region region) {
        try {
            //设置对比值
            Settings.MinSimilarity=0.58;
            //獲取教主LIST
            List<String> gus = guaiStrList();
            Match match = null;
            int count = 1;
            for (String target : gus){
                match = region.wait(target,0.5);
                while (null != match){
                    System.out.println(count);
                    match.setY(match.getY()+80);
                    match.click();
                    //查看是否被锁定
                    Match wait = region.wait("D:/software/sikulix/cs/bsd.PNG");
                    if(null != wait){
                        Match match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
                        if(null == match2){
                            match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",1);
                        }
                        match2.doubleClick();
                    }
                    //合击
                    region.type(Key.F3);
                    match = region.wait(target);
                    //防止没查到再次查询教主
                    if(null == match){
                        match = region.wait(target);
                        if(null == match){
                            match = region.wait(target);
                        }
                    }
                    count++;
                    if(count == 100){
                        //当本次循环指定次数后结束循环
                        break;
                    }
                }
            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> guaiStrList(){
        List<String> list = new ArrayList<>();
        list.add("D:/software/sikulix/image/jiaozhu1.PNG");
        list.add("D:/software/sikulix/image/jiaozhu2.PNG");
        list.add("D:/software/sikulix/image/jiaozhu3.PNG");
        list.add("D:/software/sikulix/image/jiaozhu4.PNG");
        return list;
    }
}
