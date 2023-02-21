package cesi;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import java.util.ArrayList;
import java.util.List;


public class CSdg {

    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1000,800);
        region.setThrowException(false);




        //测试道法打怪
        csdg1(region);
        //测试被锁定使用随机
        //bsd(region);
    }

    private static void bsd(Region region) {
        Settings.MinSimilarity=0.85;
        try {
            Match match = region.find("D:/software/sikulix/cs/bsd.PNG");
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
        Settings.MinSimilarity=0.7;
    }


    //道法
    private static void csdg1(Region region) {
        try {
            Region bsdReg = new Region(139,609,728,264);
            bsdReg.setThrowException(false);
            int count = 0;
            Match sdMatch = null;
            Match match = region.wait("D:/software/sikulix/cs/jiaozhu1.PNG",0.5);
            //如果教主不为空一直循环打
            while (null != match){
                 //第一次，必须激活教主并且锁定成功
                if(0 == count){
                    while (null == sdMatch){
                        //如果找不到教主了一直寻找
                        match = region.wait("D:/software/sikulix/cs/jiaozhu1.PNG",0.5);
                        while (null == match){
                            match = region.wait("D:/software/sikulix/cs/jiaozhu1.PNG",0.5);
                        }
                        match.setY(match.getY()+80);
                        match.hover();
                        //锁定
                        region.type(Key.F2);
                        //右键激活教主
                        match.rightClick();
                        //寻找英雄锁定
                        sdMatch = region.wait("D:/software/sikulix/cs/cssd.PNG",0.5);
                    }
                }else {
                    //左键鼠标悬浮
                    match.setY(match.getY()+80);
                    match.hover();
                    //锁定
                    region.type(Key.F2);
                    //施毒术
                    if((count % 10)==0 || count == 1){
                        //释放施毒术
                        region.type(Key.F4);
                        Thread.sleep(1500);
                        //查看是否被锁定
                        bsd(bsdReg);
                        //释放施毒术
                        region.type(Key.F4);
                        Thread.sleep(1500);
                        //查看是否被锁定
                        bsd(bsdReg);
                        //无极真气
                        region.type(Key.F5);
                        Thread.sleep(1000);
                    }
                    //右键跟随教主
                    match.rightClick();
                    //嗜血术
                    region.type(Key.F6);
                    //合击
                    region.type(Key.F3);
                    //查看是否被锁定
                    bsd(bsdReg);
                    match = region.wait("D:/software/sikulix/cs/jiaozhu1.PNG",8);
                }
                count++;
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
