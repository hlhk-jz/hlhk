package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
public class CurrencyData {
    //屠龙殿教主标识
    public static String tldJZ = "D:/software/sikulix/image/jiaozhu2.PNG";
    //新手教主标识
    public static String xsJZ = "D:/software/sikulix/image/jiaozhu1.PNG";
    //主体锁定目标
    public static String ztsd = "D:/software/sikulix/image/ztsd.PNG";
    //被锁定
    public static String bsd = "D:/software/sikulix/image/bsd.PNG";
    //屠龙殿NPC
    public static String tldNpc = "D:/software/sikulix/tulongdian/tld.PNG";
    //新手NPC
    public static String xsNpc = "D:/software/sikulix/image/fuli.PNG";
    //装备栏随机石
    public static String zblSjs = "D:/software/sikulix/image/shitou.PNG";

    //聊天窗口屏幕
    public static Region ckRegion = new Region(142,620,722,199);
    //新手地图缩小地图打怪
    public static Region sxRegion = new Region(291,148,440,337);
    static {
        sxRegion.setThrowException(false);
        ckRegion.setThrowException(false);
    }

    //屠龙殿/ 新手 教主
    public  static List<Object> jzList(){
        List<Object> list = new ArrayList<>();
        list.add(tldJZ);
        list.add(xsJZ);
        return list;
    }

    //关闭
    public static List<Object> initGBListObj(){
        List<Object> initList = new ArrayList<>();
        initList.add("D:/software/sikulix/image/gb.PNG");
        initList.add("D:/software/sikulix/image/gbspl.PNG");
        initList.add("D:/software/sikulix/image/bgbg.PNG");
        initList.add("D:/software/sikulix/image/gb9.PNG");
        initList.add("D:/software/sikulix/image/gb11.PNG");
        return initList;
    }

    //矿泉水属于饮料不
    public static String KQS = "D:/software/sikulix/huishou/kqs.PNG";
    public static String KQS1 = "D:/software/sikulix/huishou/kqs1.PNG";
    //一天多少小时
    public static String XS = "D:/software/sikulix/huishou/xs.PNG";
    public static String XS1 = "D:/software/sikulix/huishou/xs1.PNG";
    //赵本山哪国人
    public static String NGR = "D:/software/sikulix/huishou/ngr.PNG";
    public static String NGR1 = "D:/software/sikulix/huishou/ngr1.PNG";
    //爸爸的爸爸叫什么
    public static String JSM = "D:/software/sikulix/huishou/jsm.PNG";
    public static String JSM1 = "D:/software/sikulix/huishou/jsm1.PNG";
    //什么瓜不能吃
    public static String BCG = "D:/software/sikulix/huishou/bcg.PNG";
    public static String BCG1 = "D:/software/sikulix/huishou/bcg1.PNG";
    public static List<Object> san1Str(){
        List<Object> list = new ArrayList<>();
        list.add(KQS);
        list.add(XS);
        list.add(NGR);
        list.add(JSM);
        list.add(BCG);
        return list;
    }
    //被蚊子叮会不会痒
    public static String WZ = "D:/software/sikulix/huishou/wz.PNG";
    public static String WZ1 = "D:/software/sikulix/huishou/wz1.PNG";
    //除夕夜吃饺子
    public static String CJZ = "D:/software/sikulix/huishou/cjz.PNG";
    public static String CJZ1 = "D:/software/sikulix/huishou/cjz1.PNG";
    //多少岁内是未成年
    public static String WCN = "D:/software/sikulix/huishou/wcn.PNG";
    public static String WCN1 = "D:/software/sikulix/huishou/wcn1.PNG";
    //企鹅会飞不
    public static String QE = "D:/software/sikulix/huishou/qe.PNG";
    public static String QE1 = "D:/software/sikulix/huishou/qe1.PNG";
    public static List<Object> san4Str(){
        List<Object> list = new ArrayList<>();
        list.add(WZ);
        list.add(CJZ);
        list.add(WCN);
        list.add(QE);
        return list;
    }
    //有多少个英文字母
    public static String YWZM = "D:/software/sikulix/huishou/ywzm.PNG";
    public static String YWZM1 = "D:/software/sikulix/huishou/ywzm1.PNG";
    //犯法吗
    public static String SRFF = "D:/software/sikulix/huishou/srff.PNG";
    public static String SRFF1 = "D:/software/sikulix/huishou/srff1.PNG";
    //吸烟有害吗
    public static String XY = "D:/software/sikulix/huishou/xy.PNG";
    public static String XY1 = "D:/software/sikulix/huishou/xy1.PNG";
    //苹果电话属于国产
    public static String DH = "D:/software/sikulix/huishou/dh.PNG";
    public static String DH1 = "D:/software/sikulix/huishou/dh1.PNG";
    public static List<Object> san2Str(){
        List<Object> list = new ArrayList<>();
        list.add(YWZM);
        list.add(SRFF);
        list.add(XY);
        list.add(DH);
        return list;
    }
    //10086
    public static String ZGYD = "D:/software/sikulix/huishou/zgyd.PNG";
    public static String ZGYD1 = "D:/software/sikulix/huishou/zgyd1.PNG";
    //37度是正常体温不
    public static String TW = "D:/software/sikulix/huishou/tw.PNG";
    public static String TW1 = "D:/software/sikulix/huishou/tw1.PNG";
    //天安门在哪个城市
    public static String TAM = "D:/software/sikulix/huishou/tam.PNG";
    public static String TAM1 = "D:/software/sikulix/huishou/tam1.PNG";
    //手表一圈多少小时
    public static String SB = "D:/software/sikulix/huishou/sb.PNG";
    public static String SB1 = "D:/software/sikulix/huishou/sb1.PNG";
    public static List<Object> san3Str(){
        List<Object> list = new ArrayList<>();
        list.add(ZGYD);
        list.add(TW);
        list.add(TAM);
        list.add(SB);
        return list;
    }

    public static final String SWKEY = "swKey";
    public static final String SDKEY = "sdKey";

    public static void isTrue(Region region,int type){
        try {
            //是否需要小退
            if(!StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(SWKEY))){
                region.setX(659);
                region.setY(561);
                region.setW(255);
                region.setH(181);
                Settings.MinSimilarity= 0.8;
                Match match = region.wait("D:/software/sikulix/image/out.PNG", 2);
                if (null != match) {
                    region.setX(0);
                    region.setY(0);
                    region.setW(1200);
                    region.setH(800);
                    match.click();
                    match = region.wait("D:/software/sikulix/image/qdtc.PNG", 6);
                    match.click();
                    Thread.sleep(5000);
                    match = region.wait("D:/software/sikulix/image/ksjr.PNG", 6);
                    match.click();
                    Thread.sleep(5000);
                    match = region.wait("D:/software/sikulix/image/qdjr.PNG", 5);
                    if(null == match){
                        match = region.wait("D:/software/sikulix/image/qdjr1.PNG", 2);
                    }
                    match.click();
                    Thread.sleep(2000);
                }
                RedisUtils.redisTemplate.delete(SWKEY);
                region.setX(0);
                region.setY(0);
                region.setW(1200);
                region.setH(800);
                Settings.MinSimilarity= 0.7;
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //被锁定或者宝宝血量减少,只在打怪，捡装备时判断
        if(0 == type){
            try {
                if(!StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(SDKEY))){
                    Match match2 = region.wait(CurrencyData.zblSjs,1);
                    if(null == match2){
                        match2 = region.wait(CurrencyData.zblSjs,1);
                    }
                    if(null != match2){
                        match2.doubleClick();
                        Thread.sleep(300);
                        region.type(Key.F1);
                        match2.doubleClick();
                        Thread.sleep(300);
                        region.type(Key.F1);
                        Thread.sleep(300);
                        region.type(Key.F1);
                    }else {
                        region.type(Key.F5);
                    }
                    RedisUtils.redisTemplate.delete(SDKEY);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
