package com.util;
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
    //装备栏随机石
    public static String zblSjs = "D:/software/sikulix/image/shitou.PNG";

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
    public static List<Object> san1Str(){
        List<Object> list = new ArrayList<>();
        list.add(KQS);
        list.add(XS);
        list.add(NGR);
        list.add(JSM);
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
}
