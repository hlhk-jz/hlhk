package com;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.List;

public class SikJZB {

    public static void pickup(Region region)throws Exception{
        List<String> targetList = initTargetList();
        //判断当前地图有哪些装备
        for (String str : initTargetList()){
            Match match = region.wait(str, 0.5);
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
                location.setY(500);
                location.hover();
                match = region.wait(target,0.5);
            }
        }
    }

    public static List<String> initTargetList(){
        List<String> initList = new ArrayList<>();
        //星王
        initList.add("D:/software/sikulix/zhuangbei/xw.PNG");
        //强化
        initList.add("D:/software/sikulix/zhuangbei/qh.PNG");
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
        //霸者之刃
        initList.add("D:/software/sikulix/zhuangbei/bzzr.PNG");
        //奉天
        initList.add("D:/software/sikulix/zhuangbei/ft.PNG");
        return initList;
    }
}
