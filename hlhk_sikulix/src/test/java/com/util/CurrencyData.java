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
    //新手地图地图打怪
    public static Region xszgRegion = new Region(62,101,828,396);
    //新手地图查看空格回收
    public static Region kgRegion = new Region(4, 80,779,255);
    //合击条位置
    public static Region hjRegion = new Region(791, 644,88,165);
    //捡装备
    public static Region jzbRegion = new Region(211, 39,660,542);
    static {
        jzbRegion.setThrowException(false);
        hjRegion.setThrowException(false);
        xszgRegion.setThrowException(false);
        kgRegion.setThrowException(false);
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
    //玫瑰什么颜色
    public static String MGYS = "D:/software/sikulix/huishou/mgys.PNG";
    public static String MGYS1 = "D:/software/sikulix/huishou/mgys1.PNG";
    //大便是
    public static String DBS = "D:/software/sikulix/huishou/dbs.PNG";
    public static String DBS1 = "D:/software/sikulix/huishou/dbs1.PNG";
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
        list.add(MGYS);
        list.add(XS);
        list.add(NGR);
        list.add(DBS);
        list.add(JSM);
        list.add(BCG);
        return list;
    }
    //被蚊子叮会不会痒
    public static String WZ = "D:/software/sikulix/huishou/wz.PNG";
    public static String WZ1 = "D:/software/sikulix/huishou/wz1.PNG";
    //水果是
    public static String SGS = "D:/software/sikulix/huishou/sgs.PNG";
    public static String SGS1 = "D:/software/sikulix/huishou/sgs1.PNG";
    //好好学习
    public static String HHXX = "D:/software/sikulix/huishou/hhxx.PNG";
    public static String HHXX1 = "D:/software/sikulix/huishou/hhxx1.PNG";
    //除夕夜吃饺子
    public static String CJZ = "D:/software/sikulix/huishou/cjz.PNG";
    public static String CJZ1 = "D:/software/sikulix/huishou/cjz1.PNG";
    //多少岁内是未成年
    public static String WCN = "D:/software/sikulix/huishou/wcn.PNG";
    public static String WCN1 = "D:/software/sikulix/huishou/wcn1.PNG";
    //企鹅会飞不
    public static String QE = "D:/software/sikulix/huishou/qe.PNG";
    public static String QE1 = "D:/software/sikulix/huishou/qe1.PNG";
    //红颜色的食物是
    public static String HYS = "D:/software/sikulix/huishou/hys.PNG";
    public static String HYS1 = "D:/software/sikulix/huishou/hys1.PNG";
    public static List<Object> san4Str(){
        List<Object> list = new ArrayList<>();
        list.add(WZ);
        list.add(CJZ);
        list.add(HHXX);
        list.add(HYS);
        list.add(SGS);
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
    //人有几笔
    public static String RJB = "D:/software/sikulix/huishou/rjb.PNG";
    public static String RJB1 = "D:/software/sikulix/huishou/srff1.PNG";
    //吸烟有害吗
    public static String XY = "D:/software/sikulix/huishou/xy.PNG";
    public static String XY1 = "D:/software/sikulix/huishou/xy1.PNG";
    //苹果电话属于国产
    public static String DH = "D:/software/sikulix/huishou/dh.PNG";
    public static String DH1 = "D:/software/sikulix/huishou/dh1.PNG";
    //道士用的技能是
    public static String DSY = "D:/software/sikulix/huishou/dsy.PNG";
    public static String DSY1 = "D:/software/sikulix/huishou/dsy1.PNG";
    public static List<Object> san2Str(){
        List<Object> list = new ArrayList<>();
        list.add(YWZM);
        list.add(DSY);
        list.add(RJB);
        list.add(SRFF);
        list.add(XY);
        list.add(DH);
        return list;
    }
    //10086
    public static String ZGYD = "D:/software/sikulix/huishou/zgyd.PNG";
    public static String ZGYD1 = "D:/software/sikulix/huishou/zgyd1.PNG";
    //水泥可以做？
    public static String SNS = "D:/software/sikulix/huishou/sns.PNG";
    public static String SNS1 = "D:/software/sikulix/huishou/sns1.PNG";
    //37度是正常体温不
    public static String TW = "D:/software/sikulix/huishou/tw.PNG";
    public static String TW1 = "D:/software/sikulix/huishou/tw1.PNG";
    //哪些食物是酸的
    public static String SSD = "D:/software/sikulix/huishou/ssd.PNG";
    public static String SSD1 = "D:/software/sikulix/huishou/ssd1.PNG";
    //可以吃的是
    public static String KYC = "D:/software/sikulix/huishou/kyc.PNG";
    public static String KYC1 = "D:/software/sikulix/huishou/kyc1.PNG";
    //天安门在哪个城市
    public static String TAM = "D:/software/sikulix/huishou/tam.PNG";
    public static String TAM1 = "D:/software/sikulix/huishou/tam1.PNG";
    //手表一圈多少小时
    public static String SB = "D:/software/sikulix/huishou/sb.PNG";
    public static String SB1 = "D:/software/sikulix/huishou/sb1.PNG";
    public static List<Object> san3Str(){
        List<Object> list = new ArrayList<>();
        list.add(ZGYD);
        list.add(SSD);
        list.add(SNS);
        list.add(TW);
        list.add(TAM);
        list.add(SB);
        list.add(KYC);
        return list;
    }

    public static final String SWKEY = "swKey";
    public static final String SDKEY = "sdKey";

    public static void isTrue(Region region,int type){
        try {
            //是否需要小退
            if(!StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(SWKEY))){
                System.out.println("检测人物需要小退！！！！！");
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
                region.setH(900);
                Settings.MinSimilarity= 0.7;
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //被锁定或者宝宝血量减少,只在打怪，捡装备时判断，判断宝宝是否在线
        if(0 == type){
            try {
                if(!StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(SDKEY))){
                    System.out.println("检测到宝宝血量减少/被锁定。。。。。。。");
                    region.type(Key.F5);
                    Thread.sleep(300);
                    region.type(Key.F5);
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
                    }
                    RedisUtils.redisTemplate.delete(SDKEY);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Settings.MinSimilarity = 0.7;
        region.setX(0);
        region.setY(0);
        region.setW(1200);
        region.setH(800);
    }
}
