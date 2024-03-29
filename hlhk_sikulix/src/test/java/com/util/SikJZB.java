package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import java.util.ArrayList;
import java.util.List;

public class SikJZB {
    public static void main(String[] args)throws Exception{
        Region region = new Region(60, 0,1200,900);
        region.setThrowException(false);
     pickup();
    }

    public static void pickup()throws Exception{
        Settings.MinSimilarity = 0.65;
        //关闭弹窗
        gb();
        //英雄守护，防止捡装备不方便
        Match bgMathc = CurrencyData.bgRegion.wait(CurrencyData.BGuo, 5);
        shcg(bgMathc);
        Thread.sleep(300);
        //判断当前地图有哪些装备
        int start = 1;
        List<Match> any = CurrencyData.jzbRegion.findAnyList(initTargetListObj());
        System.out.println("当前地图检测装备数量："+any.size()+" 条！");
        if(0 != any.size()){
            for (Match matchs: any){
                matchs = CurrencyData.jzbRegion.wait(matchs.getImage(),0.5);
                while (null != matchs){
                    //判断小退，锁定
                    CurrencyData.isTrue();
                    Settings.MinSimilarity= 0.65;
                    if((start%10)==0){
                        //如果捡指定次数没捡到结束本次循环
                        break;
                    }
                    if(start == 6){
                        bgMathc = CurrencyData.bgRegion.wait("D:/software/sikulix/image/baoguo.PNG", 5);
                        bgMathc.setY(bgMathc.getY()-450);
                        bgMathc.setX(bgMathc.getX()-450);
                        bgMathc.hover();
                        Thread.sleep(300);
                        CurrencyData.bgRegion.type(Key.F4);
                    }
                    Location location = matchs.getTarget();
                    location.setY(location.getY()+8);
                    if(start == 1){
                        location.rightClick();
                        Thread.sleep(300);
                    }else {
                        location.click();
                        Thread.sleep(300);
                        CurrencyData.bgRegion.type(Key.F3);
                    }
                    Thread.sleep(300);
                    bgMathc.hover();
                    Thread.sleep(300);
                    matchs = CurrencyData.jzbRegion.wait(matchs.getImage(),0.5);
                    start ++;
                }
                start = 1;
            }
        }
        Settings.MinSimilarity = 0.7;
        //关闭弹窗
        Thread.sleep(1000);
        SikJZB.gb();
    }

    public static List<Object> initTargetListObj(){
        List<Object> initList = new ArrayList<>();
        //倚天
        initList.add("D:/software/sikulix/zhuangbei/yt.PNG");
        //狂雷
        initList.add("D:/software/sikulix/zhuangbei/kl.PNG");
        //通云
        initList.add("D:/software/sikulix/zhuangbei/ty.PNG");
        //逆火
        initList.add("D:/software/sikulix/zhuangbei/nh.PNG");
        //黄金
        initList.add("D:/software/sikulix/zhuangbei/hj.PNG");
        //赤金
        initList.add("D:/software/sikulix/zhuangbei/cj.PNG");
        //星王
        initList.add("D:/software/sikulix/zhuangbei/xw.PNG");
        //混世
        initList.add("D:/software/sikulix/zhuangbei/hs.PNG");
        //开天
        initList.add("D:/software/sikulix/zhuangbei/kt.PNG");
        initList.add("D:/software/sikulix/zhuangbei/kt1.PNG");
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
        //霸者之刃
        initList.add("D:/software/sikulix/zhuangbei/bzzr.PNG");
        //奉天
        initList.add("D:/software/sikulix/zhuangbei/ft.PNG");
        initList.add("D:/software/sikulix/zhuangbei/ft1.PNG");
        initList.add("D:/software/sikulix/zhuangbei/ftmj.PNG");
        //狂战
        initList.add("D:/software/sikulix/zhuangbei/kz3.PNG");
        //屠龙
        initList.add("D:/software/sikulix/zhuangbei/tl.PNG");
        //强化
        initList.add("D:/software/sikulix/zhuangbei/qh.PNG");
        //光芒
        initList.add("D:/software/sikulix/zhuangbei/gm.PNG");
        //雷霆
        initList.add("D:/software/sikulix/zhuangbei/lt.PNG");
        //烈焰
        initList.add("D:/software/sikulix/zhuangbei/ly.PNG");
        //100元寶
        initList.add("D:/software/sikulix/zhuangbei/yibai.PNG");
        return initList;
    }

    public static void gb()throws Exception{
        //查看有没有弹框，有就关闭，防止影响捡装备
        List<Match> matchGbs = CurrencyData.currenRegion.findAnyList(CurrencyData.initGBListObj());
        Thread.sleep(1000);
        if(!matchGbs.isEmpty()){
            for (Match match: matchGbs){
                match.click();
                Thread.sleep(1000);
            }
        }
        Thread.sleep(1000);
    }

    public static void shcg(Match bgMathc){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            bgMathc.setY(bgMathc.getY()-300);
            bgMathc.setX(bgMathc.getX()-170);
            bgMathc.hover();
            Thread.sleep(300);
            region.type(Key.F4);
            region.type(Key.F4);
            Match wait = CurrencyData.ckRegion.wait("D:/software/sikulix/img/shcg.PNG", 1);
            if (null == wait){
                bgMathc = CurrencyData.bgRegion.wait(CurrencyData.BGuo, 5);
                bgMathc.setX(bgMathc.getX()-700);
                bgMathc.setY(bgMathc.getY()-300);
                bgMathc.hover();
                Thread.sleep(300);
                region.type(Key.F4);
                region.type(Key.F4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
