package com;

import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

public class SikDaGuai {
 /*   public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        daGuai(region);
    }*/

    public static void daGuai(Region region ){
        int i = 1;
        try {
            //检查宝宝是否在线
            BaoBao.baobao(region);
            List<Object> guaiList = guaiList();
            List<Match> any = region.findAnyList(guaiList);
            List<Match> dgAll;
            Location location;
            if (!any.isEmpty()){
                //最多就循环三次,因为检索教主三个图片
                for (Match match : any){
                    region.setY(0);
                    region.setX(0);
                    region.setW(1200);
                    region.setH(800);
                    Thread.sleep(500);
                    while (match != null){
                        i++;
                        dgAll = region.findAnyList(guaiList);
                        if(!dgAll.isEmpty()){
                            match = dgAll.get(0);
                            location = match.getTarget();
                            location.setY(location.getY()+90);
                            location.click();
                            region.type(Key.F3);
                            //如果循环满十次就点击下怪基础位置，防止坐标下面100没在地图内
                            if((i%10)==0){
                                match.click();
                            }
                            //如果打怪循环超过100次，结束本次循环
                            if(i > 60){
                                System.out.println("打怪循环超过60次，结束本次循环!!!");
                                break;
                            }
                            if((i%4)==0){
                                System.out.println("缩小范围！");
                                //循环3次，就缩小下范围
                                region.setX(365);
                                region.setY(154);
                                region.setW(372);
                                region.setH(304);
                            }
                            Thread.sleep(500);
                            dgAll = region.findAnyList(guaiList);
                            Thread.sleep(800);
                            if(!dgAll.isEmpty()){
                                System.out.println(i+"搜索怪数量："+dgAll.size());
                                match = dgAll.get(0);
                            }else {
                                System.out.println(i+"未查询到怪！！！");
                                match = null;
                            }
                        }
                    }
                    i = 1;
                }
            }
        }catch (Exception e){
            //报异常后，重复调用下
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
             i = 1;
            daGuai(region);
        }
    }

    public static List<Object> guaiList(){
        List<Object> list = new ArrayList<>();
        list.add("D:/software/sikulix/image/jiaozhu1.PNG");
        list.add("D:/software/sikulix/image/jiaozhu2.PNG");
        list.add("D:/software/sikulix/image/jiaozhu3.PNG");
        return list;
    }
}
