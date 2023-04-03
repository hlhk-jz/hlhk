package com.util;
import org.sikuli.basics.Settings;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.springframework.util.StringUtils;
import java.util.*;
public class CurrencyData {
    //宝宝
    public static String BAOBAO = "D:/software/sikulix/image/baobao6.PNG";
    //包裹图标
    public static String BGuo = "D:/software/sikulix/image/baoguo.PNG";
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
    //火龍之心
    public static String HLZX = "D:/software/sikulix/image/hlzx.PNG";
    //魔血石
    public static String MXS = "D:/software/sikulix/image/mxs2.PNG";
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
    //宝宝召唤位置
    public static Region bbzhRegion = new Region(720, 563,291,173);
    //包裹位置商铺也能看到
    public static Region bgRegion = new Region(830, 518,215,290);
    //关闭扫描界面
    public static Region currenRegion = new Region(2, 18,1020,774);

    static {
        currenRegion.setThrowException(false);
        bgRegion.setThrowException(false);
        bbzhRegion.setThrowException(false);
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
        initList.add("D:/software/sikulix/image/gb111.PNG");
        initList.add("D:/software/sikulix/image/gb222.PNG");
        return initList;
    }

    public enum ZBenum{
        //矿泉水属于饮料不
        KQS(1,"D:/software/sikulix/huishou/kqs.PNG","D:/software/sikulix/huishou/kqs1.PNG"),
        //玫瑰什么颜色
        MGYS(2,"D:/software/sikulix/huishou/mgys.PNG","D:/software/sikulix/huishou/mgys1.PNG"),
        //大便是
        DBS(3,"D:/software/sikulix/huishou/dbs.PNG","D:/software/sikulix/huishou/dbs1.PNG"),
        //一天多少小时
        XS(4,"D:/software/sikulix/huishou/xs.PNG","D:/software/sikulix/huishou/xs1.PNG"),
        //赵本山哪国人
        NGR(5,"D:/software/sikulix/huishou/ngr.PNG","D:/software/sikulix/huishou/ngr1.PNG"),
        //爸爸的爸爸叫什么
        JSM(6,"D:/software/sikulix/huishou/jsm.PNG","D:/software/sikulix/huishou/jsm1.PNG"),
        //什么瓜不能吃
        BCG(7,"D:/software/sikulix/huishou/bcg.PNG","D:/software/sikulix/huishou/bcg1.PNG"),
        //被蚊子叮会不会痒
        WZ(8,"D:/software/sikulix/huishou/wz.PNG","D:/software/sikulix/huishou/wz1.PNG"),
        //水果是
        SGS(9,"D:/software/sikulix/huishou/sgs.PNG","D:/software/sikulix/huishou/sgs1.PNG"),
        //好好学习
        HHXX(10,"D:/software/sikulix/huishou/hhxx.PNG","D:/software/sikulix/huishou/hhxx1.PNG"),
        //除夕夜吃饺子
        CJZ(11,"D:/software/sikulix/huishou/cjz.PNG","D:/software/sikulix/huishou/cjz1.PNG"),
        //多少岁内是未成年
        WCN(12,"D:/software/sikulix/huishou/wcn.PNG","D:/software/sikulix/huishou/wcn1.PNG"),
        //企鹅会飞不
        QE(13,"D:/software/sikulix/huishou/qe.PNG","D:/software/sikulix/huishou/qe1.PNG"),
        //红颜色的食物是
        HYS(14,"D:/software/sikulix/huishou/hys.PNG","D:/software/sikulix/huishou/hys1.PNG"),
        //有多少个英文字母
        YWZM(15,"D:/software/sikulix/huishou/ywzm.PNG","D:/software/sikulix/huishou/ywzm1.PNG"),
        //犯法吗
        SRFF(16,"D:/software/sikulix/huishou/srff.PNG","D:/software/sikulix/huishou/srff1.PNG"),
        //人有几笔
        RJB(17,"D:/software/sikulix/huishou/rjb.PNG","D:/software/sikulix/huishou/rjb1.PNG"),
        //吸烟有害吗
        XY(18,"D:/software/sikulix/huishou/xy.PNG","D:/software/sikulix/huishou/xy1.PNG"),
        //苹果电话属于国产
        DH(19,"D:/software/sikulix/huishou/dh.PNG","D:/software/sikulix/huishou/dh1.PNG"),
        //道士用的技能是
        DSY(20,"D:/software/sikulix/huishou/dsy.PNG","D:/software/sikulix/huishou/dsy1.PNG"),
        //10086
        ZGYD(21,"D:/software/sikulix/huishou/zgyd.PNG","D:/software/sikulix/huishou/zgyd1.PNG"),
        //水泥可以做
        SNS(22,"D:/software/sikulix/huishou/sns.PNG","D:/software/sikulix/huishou/sns1.PNG"),
        //37度是正常体温不
        TW(23,"D:/software/sikulix/huishou/tw.PNG","D:/software/sikulix/huishou/tw1.PNG"),
        //哪些食物是酸的
        SSD(24,"D:/software/sikulix/huishou/ssd.PNG","D:/software/sikulix/huishou/ssd1.PNG"),
        //可以吃的是
        KYC(25,"D:/software/sikulix/huishou/kyc.PNG","D:/software/sikulix/huishou/kyc1.PNG"),
        //天安门在哪个城市
        TAM(26,"D:/software/sikulix/huishou/tam.PNG","D:/software/sikulix/huishou/tam1.PNG"),
        //手表一圈多少小时
        SB(27,"D:/software/sikulix/huishou/sb.PNG","D:/software/sikulix/huishou/sb1.PNG"),
        //飞机需要什么才能起飞
        FJ(28,"D:/software/sikulix/huishou/fj.PNG","D:/software/sikulix/huishou/fj1.PNG"),
        //马化腾创办的是
        MHT(29,"D:/software/sikulix/huishou/mht.PNG","D:/software/sikulix/huishou/mht1.PNG"),
        //红绿灯红色代表
        HLD(30,"D:/software/sikulix/huishou/hld.PNG","D:/software/sikulix/huishou/hld1.PNG"),
        //辣椒面吃在嘴里什么味道
        LJM(31,"D:/software/sikulix/huishou/ljm.PNG","D:/software/sikulix/huishou/ljm1.PNG"),
        //什么动物最抗冻
        DW(32,"D:/software/sikulix/huishou/dw.PNG","D:/software/sikulix/huishou/dw1.PNG"),
        //毛巾有何作用
        MJ(33,"D:/software/sikulix/huishou/mj.PNG","D:/software/sikulix/huishou/mj1.PNG"),
        //哪个人智商最高
        RZS(34,"D:/software/sikulix/huishou/rzs.PNG","D:/software/sikulix/huishou/rzs1.PNG"),
        //法师用的技能是
        FSY(35,"D:/software/sikulix/huishou/fsy.PNG","D:/software/sikulix/huishou/fsy1.PNG"),
        //哪种汽车品牌最贵
        QCP(36,"D:/software/sikulix/huishou/qcp.PNG","D:/software/sikulix/huishou/qcp1.PNG"),
        //什么动物在天上飞
        TSF(37,"D:/software/sikulix/huishou/tsf.PNG","D:/software/sikulix/huishou/tsf1.PNG"),
        //吃饭需要
        CFX(38,"D:/software/sikulix/huishou/cfxPNG","D:/software/sikulix/huishou/cfx1.PNG"),
        //十九层楼上是几层
        SJC(39,"D:/software/sikulix/huishou/sjc.PNG","D:/software/sikulix/huishou/sjc1.PNG"),
        //手机可以拨通
        SJB(40,"D:/software/sikulix/huishou/sjb.PNG","D:/software/sikulix/huishou/sjb1.PNG"),
        //中秋吃
        CYB(41,"D:/software/sikulix/huishou/cyb.PNG","D:/software/sikulix/huishou/cyb1.PNG"),
        //唐僧徒弟
        TST(42,"D:/software/sikulix/huishou/tst.PNG","D:/software/sikulix/huishou/tst1.PNG"),
        //什么动物是吃素的
        YCS(43,"D:/software/sikulix/huishou/ycs.PNG","D:/software/sikulix/huishou/ycs1.PNG"),
        //王宝强姓
        WBQ(44,"D:/software/sikulix/huishou/wbq.PNG","D:/software/sikulix/huishou/wbq1.PNG"),
        //羊有几只眼
        JZY(45,"D:/software/sikulix/huishou/jzy.PNG","D:/software/sikulix/huishou/jzy1.PNG"),
        //太阳每天从东方升起
        TYD(46,"D:/software/sikulix/huishou/tyd.PNG","D:/software/sikulix/huishou/tyd1.PNG");

        private int type;
        private String target1;
        private String target2;

        ZBenum(int type,String target1,String target2){
            this.type = type;
            this.target1 = target1;
            this.target2 = target2;
        }
        public static Map<String, Object> getMap(Integer... list) {
            Map<String, Object> map = new HashMap<>();
            List<Integer> integers = Arrays.asList(list);
            for (ZBenum zBenum : ZBenum.values()){
                if(integers.contains(zBenum.type)){
                    map.put(zBenum.target1,zBenum.target2 );
                }
            }
            return map;
        }
    }

    public static final String SWKEY = "swKey";
    public static final String SDKEY = "sdKey";
    public static final String XLKEY = "XLKEY";

    public static void isTrue(){
        try {
            //是否需要小退
            if(!StringUtils.isEmpty(RedisUtils.redisTemplate.opsForValue().get(SWKEY))){
                System.out.println("检测人物需要小退！！！！！");
                xiaoTui();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //將背包多餘魔血石和火龍之心扔了
    public static void rhlmx(){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            SikJZB.gb();
            Match bgMathc = region.wait("D:/software/sikulix/image/baoguo.PNG", 5);
            bgMathc.click();
            Match wait = CurrencyData.kgRegion.wait(CurrencyData.HLZX, 1);
            while (null != wait){
                wait.click();
                bgMathc.setY(bgMathc.getY()-100);
                bgMathc.hover();
                CurrencyData.isTrue();
                bgMathc.click();
                wait = CurrencyData.kgRegion.wait(CurrencyData.HLZX, 1);
            }
            wait = CurrencyData.kgRegion.wait(CurrencyData.MXS, 1);
            while (null != wait){
                wait.click();
                bgMathc.hover();
                CurrencyData.isTrue();
                bgMathc.click();
                wait = CurrencyData.kgRegion.wait(CurrencyData.MXS, 1);
            }
            wait = CurrencyData.kgRegion.wait("D:/software/sikulix/image/yuanbao.PNG", 1);
            while (null != wait){
                wait.doubleClick();
                CurrencyData.isTrue();
                wait = CurrencyData.kgRegion.wait("D:/software/sikulix/image/yuanbao.PNG", 1);
            }
            SikJZB.gb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xiaoTui()throws Exception{
        Region region = new Region(0,0);
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
}
