package com;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.List;

public class SikJZB {
  /*  public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        pickup(region);
        pickup(region);
    }*/

    public static void pickup(Region region)throws Exception{
        //寻找包裹
        Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        match.setY(match.getY()-100);
        Thread.sleep(500);
        match.hover();
        Thread.sleep(500);
        region.type(Key.F1);

        List<String> targetList = new ArrayList<>();
        //判断当前地图有哪些装备
        for (String str : initTargetList()){
             match = region.wait(str, 0.5);
            if(null != match){
                targetList.add(str);
            }
        }
        System.out.println("当前地图检测装备数量："+targetList.size()+" 条！");
        if(0 != targetList.size()){
            Match matchGb = region.find("D:/software/sikulix/image/gb.NPG");
            Thread.sleep(500);
            if(null != matchGb){
                matchGb.click();
            }
            System.out.println("本次需要捡装备数量："+targetList.size());
            for (String str : targetList){
                jzb(str,region);
            }
        }else {
            //如果没有装备要捡继续随机
            SikHandler.tulongdianMethod(region);
        }
    }

    private static void jzb(String target,Region region)throws Exception {
        Match match = region.find(target);
        Thread.sleep(500);
        if(null != match){
            match.rightClick();
            while (null != match){
                Location location = match.getTarget();
                location.setY(location.getY()+5);
                location.click();
                Thread.sleep(800);
                location.setY(200);
                location.hover();
                match = region.wait(target,0.5);
            }
        }
    }

    public static List<String> initTargetList(){
        List<String> initList = new ArrayList<>();
        //倚天
        initList.add("D:/software/sikulix/zhuangbei/yt.PNG");
        //星王
        initList.add("D:/software/sikulix/zhuangbei/xw.PNG");
        //混世
        initList.add("D:/software/sikulix/zhuangbei/hs.PNG");
        //开天
        initList.add("D:/software/sikulix/zhuangbei/kt.PNG");
        //玄天
        initList.add("D:/software/sikulix/zhuangbei/xt.PNG");
        //圣魔
        initList.add("D:/software/sikulix/zhuangbei/sm.PNG");
        //太极
        initList.add("D:/software/sikulix/zhuangbei/tj.PNG");
        initList.add("D:/software/sikulix/zhuangbei/tj2.PNG");
        //真魂
        initList.add("D:/software/sikulix/zhuangbei/zh.PNG");
        //战神
        initList.add("D:/software/sikulix/zhuangbei/zs.PNG");
        //震天
        initList.add("D:/software/sikulix/zhuangbei/zt.PNG");
        //狂雷
        initList.add("D:/software/sikulix/zhuangbei/kl.PNG");
        //通云
        initList.add("D:/software/sikulix/zhuangbei/ty.PNG");
        //逆火
        initList.add("D:/software/sikulix/zhuangbei/nh.PNG");
        //黄金
        initList.add("D:/software/sikulix/zhuangbei/hj.PNG");
        //词金
        initList.add("D:/software/sikulix/zhuangbei/cj.PNG");
        //霸者之刃
        initList.add("D:/software/sikulix/zhuangbei/bzzr.PNG");
        //奉天
        initList.add("D:/software/sikulix/zhuangbei/ft.PNG");
        return initList;
    }
}
