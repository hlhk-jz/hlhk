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
    //新手福利
    public static String xsNPC = "D:/software/sikulix/image/fuli.PNG";
    //土城NPC
    public static String tcNpc = "D:/software/sikulix/image/tc.PNG";
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
}
