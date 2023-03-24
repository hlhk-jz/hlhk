package com.xinshou;
import com.util.CurrencyData;
import com.util.SikJZB;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    public static void pdty(Region region)throws Exception{
        Region ziReg = new Region(0,114,399,134);
        ziReg.setThrowException(false);
        Map<String,Object> map = CurrencyData.ZBenum.getMap(28,30,29,41,42,32,39,36,28,43,40,44);
        Set<String> set = map.keySet();
        Match match = null;
        boolean isTrue = true;
        for (String str : set){
            match = region.wait(str,1 );
            if(null != match){
                match = ziReg.wait(map.get(str),2);
                if(null != match){
                    match.click();
                    isTrue = false;
                    break;
                }
            }
        }
        //如果没有查到，刷新
        if(isTrue){
            //如果一直没有符合的，点击刷新
            match = region.wait("D:/software/sikulix/huishou/sxsx.PNG",1);
            if(null == match){
                System.out.println("未查询到刷新按钮！！！！！");
                XinShouHandler.tcHuiShou(region);
            }
            match.click();
            pdty(region);
        }

        match = region.wait("D:/software/sikulix/image/hs6.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs6.PNG",3);
        }
        match.click();
        match = region.wait("D:/software/sikulix/image/hs6.PNG",1);
        if(null == match){
            match = region.wait("D:/software/sikulix/image/hs6.PNG",3);
        }
        match.click();
    }
}
