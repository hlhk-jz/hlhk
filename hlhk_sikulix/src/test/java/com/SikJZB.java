package com;
import org.sikuli.script.*;

import java.util.ArrayList;
import java.util.List;

public class SikJZB {
  /*  public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        pickup(region);
    }*/

    public static void pickup(Region region)throws Exception{
        Region jzbRegion = new Region(60, 0,1200,800);
        jzbRegion.setThrowException(false);
        //寻找包裹,让鼠标悬浮背包上面，英雄守护那，防止捡装备不方便
        Match bgMathc = jzbRegion.wait("D:/software/sikulix/image/baoguo.PNG", 1);
        bgMathc.setY(bgMathc.getY()-100);
        Thread.sleep(500);
        bgMathc.hover();
        Thread.sleep(500);
        //守护
        jzbRegion.type(Key.F4);

        //判断当前地图有哪些装备
        int start = 1;
        List<Match> any = jzbRegion.findAnyList(initTargetListObj());
        System.out.println("当前地图检测装备数量："+any.size()+" 条！");
        if(0 != any.size()){
            //查看有没有弹框，有就关闭，防止影响捡装备
            List<Match> matchGbs = jzbRegion.findAnyList(initGBListObj());
            if(!matchGbs.isEmpty()){
                for (Match match: matchGbs){
                    match.click();
                }
            }
            for (Match matchs: any){
                while (null != matchs){
                    if((start%15)==0){
                        //如果捡15次没捡到结束本次
                        break;
                    }
                    Location location = matchs.getTarget();
                    location.setY(location.getY()+8);
                    if(start == 1){
                        location.rightClick();
                    }
                    location.setY(location.getY()+100);
                    location.hover();
                    region.type(Key.F4);
                    Thread.sleep(300);
                    matchs = jzbRegion.wait(matchs.getImage(),0.5);
                    start ++;
                }
                start = 1;
            }
        }
    }

    public static List<Object> initTargetListObj(){
        List<Object> initList = new ArrayList<>();
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
        //狂战
        initList.add("D:/software/sikulix/zhuangbei/kz3.PNG");
        //强化
        initList.add("D:/software/sikulix/zhuangbei/qh.PNG");
        initList.add("D:/software/sikulix/zhuangbei/qh2.PNG");
        return initList;
    }

    public static List<Object> initGBListObj(){
        List<Object> initList = new ArrayList<>();
        initList.add("D:/software/sikulix/image/gb.PNG");
        initList.add("D:/software/sikulix/image/gbspl.PNG");
        initList.add("D:/software/sikulix/image/bgbg.PNG");
        return initList;
    }
}
