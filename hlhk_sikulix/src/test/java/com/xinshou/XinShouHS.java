package com.xinshou;
import com.util.CurrencyData;
import com.util.SikJZB;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import java.util.List;

//新手回收，没有回收权限回土城
public class XinShouHS {
       public static void main(String[] args){
        try {
            Region region = new Region(0, 0,1200,800);
            region.setThrowException(false);
            Match match = region.wait("D:/software/sikulix/xinshou/hszb.PNG",1);
            match.click();
            xshs(region);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xshs(Region region)throws Exception{
        SikJZB.gb(region);
        Match match = region.wait("D:/software/sikulix/image/hs5.PNG",2);
        //如果没有回收问题，点击回收
        if(null != match){
            match.click();
            match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
            match.click();
        }else {
            region.setX(0);
            region.setY(0);
            region.setW(515);
            region.setH(302);
            pdty(region);
            region.setX(0);
            region.setY(0);
            region.setW(1200);
            region.setH(800);
        }
    }

    //判断是哪一组
    public static void pdty(Region region)throws Exception{
        Region ziReg = new Region(0,114,399,134);
        boolean isTrue = true;
        List<Match> list = region.findAnyList(CurrencyData.san1Str());
        if(!list.isEmpty()){
            hs1(region,ziReg);
            isTrue = false;
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san2Str());
            if(!list.isEmpty()){
                hs2(region,ziReg);
                isTrue = false;
            }
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san3Str());
            if(!list.isEmpty()){
                hs3(region,ziReg);
                isTrue = false;
            }
        }
        if(isTrue){
            list = region.findAnyList(CurrencyData.san4Str());
            if(!list.isEmpty()){
                hs4(region,ziReg);
                isTrue = false;
            }
        }
        //如果没有查到，刷新
        if(isTrue){
            //如果一直没有符合的，点击刷新
            Match match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
    }

    private static void hs4(Region region,Region ziReg)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //被蚊子叮会不会痒
        if(isTrue){
            match = region.wait(CurrencyData.WZ,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.WZ1,2);
                match.click();
                isTrue = false;
            }
        }

        //除夕夜吃饺子
        if(isTrue){
            match = region.wait(CurrencyData.CJZ,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.CJZ1,2);
                match.click();
                isTrue = false;
            }
        }

        //水果是
        if(isTrue){
            match = region.wait(CurrencyData.SGS,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.SGS1,2);
                match.click();
                isTrue = false;
            }
        }

        //好好学习
        if(isTrue){
            match = region.wait(CurrencyData.HHXX,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.HHXX1,2);
                match.click();
                isTrue = false;
            }
        }

        //多少岁内是未成年
        if(isTrue){
            match = region.wait(CurrencyData.WCN,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.WCN1,2);
                match.click();
                isTrue = false;
            }
        }

        //企鹅会飞不
        if(isTrue){
            match = region.wait(CurrencyData.QE,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.QE1,2);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
        match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        match.click();
    }

    private static void hs3(Region region,Region ziReg)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //10086
        if(isTrue){
            match = region.wait(CurrencyData.ZGYD,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.ZGYD1,2);
                match.click();
                isTrue = false;
            }
        }
        //水泥可以做
        if(isTrue){
            match = region.wait(CurrencyData.SNS,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.SNS1,2);
                match.click();
                isTrue = false;
            }
        }
        //可以吃的是
        if(isTrue){
            match = region.wait(CurrencyData.KYC,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.KYC1,2);
                match.click();
                isTrue = false;
            }
        }

        //哪些食物是酸的
        if(isTrue){
            match = region.wait(CurrencyData.SSD,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.SSD1,2);
                match.click();
                isTrue = false;
            }
        }

        //37度是正常体温不
        if(isTrue){
            match = region.wait(CurrencyData.TW,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.TW1,2);
                match.click();
                isTrue = false;
            }
        }

        //天安门在哪个城市
        if(isTrue){
            match = region.wait(CurrencyData.TAM,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.TAM1,2);
                match.click();
                isTrue = false;
            }
        }

        //手表一圈多少小时
        if(isTrue){
            match = region.wait(CurrencyData.SB,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.SB1,2);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
        match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        match.click();
    }

    private static void hs2(Region region,Region ziReg)throws Exception {
        boolean isTrue = true;
        Match match = null;
        //有多少个英文字母
        if(isTrue){
            match = region.wait(CurrencyData.YWZM,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.YWZM1,2);
                match.click();
                isTrue = false;
            }
        }

        //犯法吗
        if(isTrue){
            match = region.wait(CurrencyData.SRFF,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.SRFF1,2);
                match.click();
                isTrue = false;
            }
        }

        //人有几笔
        if(isTrue){
            match = region.wait(CurrencyData.RJB,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.RJB1,2);
                match.click();
                isTrue = false;
            }
        }

        //吸烟有害吗
        if(isTrue){
            match = region.wait(CurrencyData.XY,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.XY1,2);
                match.click();
                isTrue = false;
            }
        }

        //苹果电话属于国产
        if(isTrue){
            match = region.wait(CurrencyData.DH,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.DH1,2);
                match.click();
                isTrue = false;
            }
        }
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
        match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        match.click();
    }

    private static void hs1(Region region,Region ziReg) throws Exception{
        boolean isTrue = true;
        Match match = null;
        //矿泉水属于饮料不
        match = region.wait(CurrencyData.KQS,1);
        if(null != match){
            match = ziReg.wait(CurrencyData.KQS1,2);
            match.click();
            isTrue = false;
        }

        //玫瑰什么颜色
        if(isTrue) {
            match = region.wait(CurrencyData.MGYS, 1);
            if (null != match) {
                match = ziReg.wait(CurrencyData.MGYS1, 2);
                match.click();
                isTrue = false;
            }
        }

        //大便是
        if(isTrue) {
            match = region.wait(CurrencyData.DBS, 1);
            if (null != match) {
                match = ziReg.wait(CurrencyData.DBS1, 2);
                match.click();
                isTrue = false;
            }
        }

        //一天多少小时
        if(isTrue){
            match = region.wait(CurrencyData.XS,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.XS1,2);
                match.click();
                isTrue = false;
            }
        }

        //赵本山哪国人
        if(isTrue){
            match = region.wait(CurrencyData.NGR,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.NGR1,2);
                match.click();
                isTrue = false;
            }
        }

        //什么瓜不能吃
        if(isTrue){
            match = region.wait(CurrencyData.BCG,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.BCG1,2);
                match.click();
                isTrue = false;
            }
        }

        //爸爸的爸爸叫什么
        if(isTrue){
            match = region.wait(CurrencyData.JSM,1);
            if(null != match){
                match = ziReg.wait(CurrencyData.JSM1,2);
                match.click();
                isTrue = false;
            }
        }

        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            match.click();
            pdty(region);
        }
        match = region.wait("D:/software/sikulix/image/hs5.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs7.PNG",1);
        }
        match.click();
        match = region.wait("D:/software/sikulix/xinshou/qdhs.PNG",2);
        match.click();
    }
}
