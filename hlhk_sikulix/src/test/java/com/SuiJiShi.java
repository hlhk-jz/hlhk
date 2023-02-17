package com;

import com.google.common.collect.Iterators;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.Iterator;

public class SuiJiShi {
  /*  public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        for (int i = 0;i<5;i++){
            suiJiShi(region);
        }
    }*/
    //查看随机石是否充足
    public static void suiJiShi(Region region)throws Exception{
        //寻找包裹
        Match match = region.wait("D:/software/sikulix/image/baoguo.PNG", 2);
        match.click();
        //查看随机石总数
        Thread.sleep(300);
        Iterator<Match> all = region.findAll("D:/software/sikulix/tulongdian/shitou3.PNG");
        Thread.sleep(1000);
        int size = Iterators.size(all);
        if(size < 3){
            //防止没检查出来，再次查询
            all = region.findAll("D:/software/sikulix/tulongdian/shitou3.PNG");
            if(Iterators.size(all) < 3){
                //如果随机石小于3就在商城买点
                //如果没有随机石，在商城买，寻找商铺
                match = region.wait("D:/software/sikulix/image/pu.PNG", 2);
                match.click();
                //寻找补给
                match = region.wait("D:/software/sikulix/image/bj.PNG", 2);
                if (null == match){
                    match = region.wait("D:/software/sikulix/image/bj2.PNG", 2);
                }
                match.click();
                //找石头
                match = region.wait("D:/software/sikulix/image/mst.PNG", 2);
                match.click();
                //找购买按键
                match = region.wait("D:/software/sikulix/image/gm.PNG", 2);
                match.click();
                //确定
                match = region.wait("D:/software/sikulix/image/qd.PNG", 2);
                match.click();
                //关闭商铺栏
                match = region.wait("D:/software/sikulix/image/gbspl.PNG", 2);
                if(null != match){
                    match.click();
                }
            }
        }
        //关闭物品栏
        match = region.wait("D:/software/sikulix/image/gbzbl.PNG", 1);
        if(null != match){
            match.click();
        }
    }
}
