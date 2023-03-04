package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import java.util.List;

//回收装备
public class SikHS {
    public static void main(String[] args){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            jzb(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jzb(Region region)throws Exception{
        Settings.MinSimilarity = 0.7;
        Match match = region.wait("D:/software/sikulix/image/hs1.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs11.PNG",1);
            if(null == match){
                match = region.wait("D:/software/sikulix/image/hs4.PNG",1);
            }
        }
        Thread.sleep(500);
        match.click();
        Thread.sleep(500);
        region.type(Key.ENTER);
        Thread.sleep(500);
        region.type("@fuwu");
        Thread.sleep(500);
        region.type(Key.SPACE);
        Thread.sleep(500);
        region.type(Key.ENTER);
        //查找 回收装备 选项
        match = region.find("D:/software/sikulix/image/hs2.PNG");
        Thread.sleep(700);
        if(null == match){
            match = region.find("D:/software/sikulix/image/hs3.PNG");
        }
        match.click();
        Thread.sleep(500);
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        //如果没有回收问题，点击回收
        if(null != match){
            match.click();
        }else {
            region.setX(0);
            region.setY(0);
            region.setW(496);
            region.setH(276);
            pdty(region);
            region.setX(0);
            region.setY(0);
            region.setW(1200);
            region.setH(800);
        }
    }

    //判断是哪一组
    public static void pdty(Region region)throws Exception{
        boolean isTrue = true;
        List<Match> list = region.findAnyList(CurrencyData.san1Str());
        if(!list.isEmpty()){
          hs1(region);
          isTrue = false;
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san2Str());
            if(!list.isEmpty()){
                hs2(region);
                isTrue = false;
            }
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san3Str());
            if(!list.isEmpty()){
                hs3(region);
                isTrue = false;
            }
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san4Str());
            if(!list.isEmpty()){
                hs4(region);
                isTrue = false;
            }
        }
        //如果没有查到，刷新
        if(isTrue){
            //如果一直没有符合的，点击刷新
            Match match = region.find("D:/software/sikulix/huishou/sxsx.PNG");
            Thread.sleep(500);
            match.click();
            pdty(region);
        }
    }

    private static void hs4(Region region)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //被蚊子叮会不会痒
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/wz.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/wz1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //除夕夜吃饺子
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/cjz.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/cjz1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //多少岁内是未成年
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/wcn.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/wcn1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //企鹅会飞不
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/qe.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/qe1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.find("D:/software/sikulix/huishou/sxsx.PNG");
            Thread.sleep(500);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
    }

    private static void hs3(Region region)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //10086
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/zgyd.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/zgyd1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //37度是正常体温不
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/tw.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/tw1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //天安门在哪个城市
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/tam.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/tam1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //手表一圈多少小时
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/sb.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/sb1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.find("D:/software/sikulix/huishou/sxsx.PNG");
            Thread.sleep(500);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
    }

    private static void hs2(Region region)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //有多少个英文字母
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/ywzm.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/ywzm1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //犯法吗
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/srff.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/srff1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //吸烟有害吗
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/xy.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/xy1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //苹果电话属于国产
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/dh.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/dh1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.find("D:/software/sikulix/huishou/sxsx.PNG");
            Thread.sleep(500);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
    }

    private static void hs1(Region region) throws Exception{
        boolean isTrue = true;
        Match match = null;
        //矿泉水属于饮料不
        match = region.find("D:/software/sikulix/huishou/kqs.PNG");
        Thread.sleep(500);
        if(null != match){
            match = region.find("D:/software/sikulix/huishou/kqs1.PNG");
            Thread.sleep(500);
            match.click();
            isTrue = false;
        }

        //一天多少小时
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/xs.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/xs1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //赵本山哪国人
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/ngr.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/ngr1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        //爸爸的爸爸叫什么
        if(isTrue){
            match = region.find("D:/software/sikulix/huishou/jsm.PNG");
            Thread.sleep(500);
            if(null != match){
                match = region.find("D:/software/sikulix/huishou/jsm1.PNG");
                Thread.sleep(500);
                match.click();
                isTrue = false;
            }
        }

        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.find("D:/software/sikulix/huishou/sxsx.PNG");
            Thread.sleep(500);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
    }

}
