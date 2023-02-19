package com;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import java.util.ArrayList;
import java.util.List;

//打怪
public class SikDaGuai {
   /* public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        daGuai(region);
    }*/


   //战法
    public static void daGuai(Region region ){
        int count = 1;
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
             //设置对比值
            Settings.MinSimilarity=0.58;
            //獲取教主LISTtr
            List<String> gus = guaiStrList();
            Match match = null;
            for (String target : gus){
                match = region.wait(target,0.5);
                while (null != match){
                    System.out.println(count);
                    match.setY(match.getY()+80);
                    match.click();
                    //查看是否被锁定
                    Match wait = region.wait("D:/software/sikulix/cs/bsd.PNG");
                    if(null != wait){
                        Match match2 = region.wait("D:/software/sikulix/tulongdian/shitou.PNG",0.5);
                        if(null == match2){
                            match2 = region.wait("D:/software/sikulix/tulongdian/shitou2.PNG",1);
                        }
                        match2.doubleClick();
                    }
                    //合击
                    region.type(Key.F3);
                    match = region.wait(target);
                    //防止没查到再次查询教主
                    if(null == match){
                        match = region.wait(target);
                        if(null == match){
                            match = region.wait(target);
                        }
                    }
                    count++;
                    if(count == 200){
                        //当本次循环指定次数后结束循环
                        break;
                    }
                }
                count = 1;
            }
        }catch (Exception e){
            //报异常后，重复调用下
            try {
                Thread.sleep(3000);
                e.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            count = 1;
            daGuai(region);
        }
    }


    //道法
  /*  public static void daGuai(Region region ){
        int i = 1;
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
            List<Object> guaiList = guaiList();
            List<Match> dgAll;
            Location location;
            Match match;
            //循环指定次数
            for (int st = 1;st<4;st++){
                region.setY(0);
                region.setX(0);
                region.setW(1000);
                region.setH(800);
                Thread.sleep(500);
                List<Match> any = region.findAnyList(guaiList);
                System.out.println("第 "+st+" 次查找数量："+any.size());
                Thread.sleep(1000);
                if(!any.isEmpty()){
                    match = any.get(0);
                    while (match != null){
                        match = region.wait(match.getImage(),1);
                        if(null != match){
                            location = match.getTarget();
                            location.setY(location.getY()+80);
                            if((i%4)==0){
                                //施毒术
                                System.out.println("施毒术！！！");
                                location.hover();
                                region.type(Key.F4);
                                Thread.sleep(1000);
                                region.type(Key.F4);
                            }else {
                                location.rightClick();
                            }
                            //锁定
                            region.type(Key.F2);
                            //无极真气
                            region.type(Key.F5);
                            //合击
                            region.type(Key.F3);

                            //如果循环满指定次数就点击下怪基础位置，防止坐标下面100没在地图内
                            if((i%8)==0){
                                match.setY(match.getY()-90);
                                Thread.sleep(300);
                                match.rightClick();
                            }
                            //如果打怪循环超过100次，结束本次循环
                            if(i > 100){
                                System.out.println("打怪循环超过60次，结束本次循环!!!");
                                break;
                            }
                            if((i%4)==0){
                                System.out.println("缩小范围！");
                                //循环指定次数次，就缩小下范围
                                region.setX(267);
                                region.setY(95);
                                region.setW(492);
                                region.setH(401);
                            }
                            Thread.sleep(500);
                            dgAll = region.findAnyList(guaiList);
                            Thread.sleep(1000);
                            if(dgAll.isEmpty()){
                                dgAll = region.findAnyList(guaiList);
                                Thread.sleep(1000);
                            }
                            if(!dgAll.isEmpty()){
                                System.out.println(i+"搜索怪数量："+dgAll.size());
                                match = dgAll.get(0);
                            }else {
                                System.out.println(i+"未查询到怪！！！");
                                match = null;
                            }
                            i++;
                        }
                    }
                    i = 1;
                }
            }
        }catch (Exception e){
            //报异常后，重复调用下
            try {
                Thread.sleep(3000);
                e.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            i = 1;
            daGuai(region);
        }
    }*/

    //战道
   /* public static void daGuai(Region region ){
        int i = 1;
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
            List<Object> guaiList = guaiList();
            List<Match> dgAll;
            Location location;
            Match match;
            //循环指定次数
            for (int st = 1;st<4;st++){
                region.setY(0);
                region.setX(0);
                region.setW(1000);
                region.setH(800);
                Thread.sleep(500);
                List<Match> any = region.findAnyList(guaiList);
                System.out.println("第 "+st+" 次查找数量："+any.size());
                Thread.sleep(1000);
                if(!any.isEmpty()){
                    match = any.get(0);
                    while (match != null){
                        match = region.wait(match.getImage(),1);
                        if(null != match){
                            location = match.getTarget();
                            location.setY(location.getY()+80);
                            location.click();
                            region.type(Key.F3);
                            //如果循环满指定次数就点击下怪基础位置，防止坐标下面100没在地图内
                            if((i%8)==0){
                                match.setY(match.getY()-90);
                                Thread.sleep(300);
                                match.rightClick();
                            }
                            //如果打怪循环超过100次，结束本次循环
                            if(i > 60){
                                System.out.println("打怪循环超过60次，结束本次循环!!!");
                                break;
                            }
                            if((i%4)==0){
                                System.out.println("缩小范围！");
                                //循环指定次数次，就缩小下范围
                                region.setX(267);
                                region.setY(95);
                                region.setW(492);
                                region.setH(401);
                            }
                            Thread.sleep(500);
                            dgAll = region.findAnyList(guaiList);
                            Thread.sleep(1000);
                            if(dgAll.isEmpty()){
                                dgAll = region.findAnyList(guaiList);
                                Thread.sleep(1000);
                            }
                            if(!dgAll.isEmpty()){
                                System.out.println(i+"搜索怪数量："+dgAll.size());
                                match = dgAll.get(0);
                            }else {
                                System.out.println(i+"未查询到怪！！！");
                                match = null;
                            }
                            i++;
                        }
                    }
                    i = 1;
                }
            }
        }catch (Exception e){
            //报异常后，重复调用下
            try {
                Thread.sleep(3000);
                e.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
             i = 1;
            daGuai(region);
        }
    }*/


    public static List<Object> guaiList(){
        List<Object> list = new ArrayList<>();
        list.add("D:/software/sikulix/image/jiaozhu1.PNG");
        list.add("D:/software/sikulix/image/jiaozhu2.PNG");
        list.add("D:/software/sikulix/image/jiaozhu3.PNG");
        list.add("D:/software/sikulix/image/jiaozhu4.PNG");
        return list;
    }


    public static List<String> guaiStrList(){
        List<String> list = new ArrayList<>();
        list.add("D:/software/sikulix/image/jiaozhu1.PNG");
        list.add("D:/software/sikulix/image/jiaozhu2.PNG");
        list.add("D:/software/sikulix/image/jiaozhu3.PNG");
        list.add("D:/software/sikulix/image/jiaozhu4.PNG");
        return list;
    }
}
