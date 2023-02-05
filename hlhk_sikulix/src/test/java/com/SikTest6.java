package com;

import org.sikuli.script.*;
//新手地图
public class SikTest6 {
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);

        //寻找新手福利npc
        Match match = region.find("D:/software/sikulix/image/fuli.PNG");
        int i = 1;
        Thread.sleep(5000);
        if(null != match){
            Thread.sleep(300);
            //点击新手福利npc
            match.click();
            Thread.sleep(300);
            //寻找进入新手福利描述
            Match match1 = region.find("D:/software/sikulix/image/ru.PNG");
            Thread.sleep(300);
            //点击进入新手福利
            match1.click();
            Thread.sleep(300);
            //寻找随机石
            Match match2 = region.find("D:/software/sikulix/image/shitou.PNG");
            Thread.sleep(300);
            //点击随机石
            match2.doubleClick();
            Thread.sleep(300);
            //寻找教主
            Match match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
            if(null == match3){
                Thread.sleep(300);
                while (true){
                    //如果找到教主了推出循环
                    if(null != match3){
                        break;
                    }
                    //点击随机石
                    match2.doubleClick();
                    Thread.sleep(2000);
                    //寻找教主
                    match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                    if (null != match3){
                        break;
                    }
                }
            }

           //找到教主后
            Match suoding = null;
            while (match3 != null){
                match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                try {
                    while (suoding == null  && i != 5){
                        //1. 点击教主激活
                        match3.click();
                        Thread.sleep(300);
                        match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                        //2. 鼠标悬浮教主
                        match3.getTarget().hover();
                        //3. 锁定
                        region.type(Key.F3);
                        Thread.sleep(300);
                        suoding = region.find("D:/software/sikulix/image/suoding.PNG");
                        //如果5次后还锁定不了就退出锁定
                        i++;
                    }
                    //4. 合计
                    region.type(Key.F4);
                    Thread.sleep(5000);
                    match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                    Thread.sleep(300);
                    i = 1;
                    suoding = null;
                }catch (Exception e){
                    System.out.println("异常~~~~~");
                }
            }
        }
    }


    public static void pickup(String target)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        Match match = region.find(target);
        match.rightClick();
        if(null != match){
            while (null != match){
                match.click();
                Thread.sleep(500);
                match = region.find(target);
                Thread.sleep(500);
            }
        }
    }
}


/*class Testss{
    public static void main(String[] args)throws Exception{
        Region region = new Region(0, 0,1920,1080);
        region.setThrowException(false);
        int i = 1;
        while (true){
            Thread.sleep(5000);
            Match match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
            Match match2 = null;
            //找到教主后
            while (match3 != null){
                match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                try {
                    while (match2 == null  && i != 5){
                        //1. 点击教主激活
                        match3.click();
                        Thread.sleep(300);
                        match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                        //2. 鼠标悬浮教主
                        match3.getTarget().hover();
                        //3. 锁定
                        region.type(Key.F3);
                        Thread.sleep(300);
                        match2 = region.find("D:/software/sikulix/image/suoding.PNG");
                        //如果5次后还锁定不了就退出锁定
                        i++;
                    }
                    //4. 合计
                    region.type(Key.F4);
                    Thread.sleep(5000);
                    match3 = region.find("D:/software/sikulix/image/jiaozhu.PNG");
                    Thread.sleep(300);
                    i = 1;
                    match2 = null;
                }catch (Exception e){
                    System.out.println("异常~~~~~");
                }

            }
        }

    }
}*/

