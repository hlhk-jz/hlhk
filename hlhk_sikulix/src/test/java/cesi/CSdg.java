package cesi;

import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

//测试打怪
public class CSdg {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);
        daGuai(region);
    }

    public static void daGuai(Region region) {
        try {
            //设置对比值
            Settings.MinSimilarity=0.57;

            System.out.println(region);
            List<Match> any = region.findAnyList(guaiList());
            Thread.sleep(1000);
            System.out.println("怪数量"+any.size());
            if(!any.isEmpty()){
                for (Match match : any){
                    match.hover();
                }

            }




        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Object> guaiList(){
        List<Object> list = new ArrayList<>();
        list.add("D:/software/sikulix/cs/jiaozhu3.PNG");
        list.add("D:/software/sikulix/cs/jiaozhu2.PNG");
        list.add("D:/software/sikulix/cs/jiaozhu1.PNG");
        return list;
    }
}
