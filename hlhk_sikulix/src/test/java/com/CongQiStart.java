package com;
import com.util.CurrencyData;
import org.sikuli.script.*;
//重启
public class CongQiStart {
    public static void main(String[] args)throws Exception{
        //csydwz();
        cq();
    }

    //测试移动左上位置
    private static void csydwz() {
        try {
            Match xia1 = CongQiStart.tjReg.wait("D:/software/sikulix/cq/rw.PNG", 2);
            xia1.hover();
            Thread.sleep(500);
            CongQiStart.tjReg.mouseDown(Button.LEFT);
            Match xia = CongQiStart.tjReg.wait("D:/software/sikulix/cq/dn.PNG", 2);
            Location location = xia.getTarget();
            location.setX(location.getX()+58);
            location.setY(location.getY()-30);
            //将鼠标指针移动到指定位置
            CongQiStart.tjReg.mouseMove(location);
            Thread.sleep(500);
            //松开左键
            CongQiStart.tjReg.mouseUp(Button.LEFT);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //右侧IDEA界面
    public static Region cqReg = new Region(1027, 0,893,1042);
    //底部区域
    public static Region dbReg = new Region(288, 1026,738,54);
    //区组位置
    public static Region qzReg = new Region(557, 268,566,552);
    //提交，以及移动左上
    public static Region tjReg = new Region(0, 0,1343,963);
    //没成功进入黑屏，查找 叉
    public static Region caReg = new Region(1394, 107,122,86);

    static {
        caReg.setThrowException(false);
        tjReg.setThrowException(false);
        qzReg.setThrowException(false);
        dbReg.setThrowException(false);
        cqReg.setThrowException(false);
    }


    public static void cq(){
        try {
            while (true){
                Thread.sleep(30000);
                Match wait = CongQiStart.tjReg.wait(CurrencyData.BAOBAO, 2);
                if(null == wait){
                    Thread.sleep(120000);
                    wait = CongQiStart.tjReg.wait(CurrencyData.BAOBAO, 2);
                    if(null == wait){
                        System.out.println("重启中！！！！！！！！！！！！！！！！");
                        //寻找程序关闭
                        Match match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/xsstart.PNG", 2);
                        if(null != match){
                            match.click();
                            match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/tz.PNG", 2);
                            if(null != match){
                                match.click();
                            }
                        }

                        //底部寻找传奇窗口，点击关闭
                        match = CongQiStart.dbReg.wait("D:/software/sikulix/cq/cq.PNG", 2);
                        if(null != match){
                            match.click();
                            match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/gbcq.PNG", 5);
                            if(null != match){
                                match.click();
                            }else {
                                match = CongQiStart.dbReg.wait("D:/software/sikulix/cq/cq.PNG", 2);
                                if(null != match){
                                    match.click();
                                    match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/gbcq.PNG", 5);
                                    if(null != match){
                                        match.click();
                                    }
                                }
                            }
                        }
                        //寻找传奇图标
                        match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/cqtb.PNG", 3);
                        if(null != match){
                            match.doubleClick();
                        }
                        //寻找区组
                        match = CongQiStart.qzReg.wait("D:/software/sikulix/cq/qz.PNG", 10);
                        if(null != match){
                            match.click();
                        }else {
                            match = CongQiStart.qzReg.wait("D:/software/sikulix/cq/qz.PNG", 10);
                            if(null != match){
                                match.click();
                            }
                        }
                        //寻找开始游戏
                        match = CongQiStart.qzReg.wait("D:/software/sikulix/cq/ksyx.PNG", 5);
                        if(null != match){
                            match.click();
                            Thread.sleep(8000);
                            //输入账号密码
                            CongQiStart.qzReg.type("hlhkcc");
                            Thread.sleep(300);
                            CongQiStart.qzReg.type(Key.TAB);
                            Thread.sleep(300);
                            CongQiStart.qzReg.type("jiangzhi");
                            Thread.sleep(300);
                            //提交
                            match = CongQiStart.tjReg.wait("D:/software/sikulix/cq/tj.PNG", 10);
                            if(null != match){
                                match.click();

                                //看是否锁定账号
                                match = CongQiStart.tjReg.wait("D:/software/sikulix/cq/ycsd.PNG", 2);
                                if(null != match){
                                    match = CongQiStart.tjReg.wait("D:/software/sikulix/cq/qd.PNG", 2);
                                    match.click();
                                    //输入账号密码
                                    CongQiStart.qzReg.type("hlhkcc");
                                    Thread.sleep(300);
                                    CongQiStart.qzReg.type(Key.TAB);
                                    Thread.sleep(300);
                                    CongQiStart.qzReg.type("jiangzhi");
                                    Thread.sleep(300);
                                    //提交
                                    match = CongQiStart.tjReg.wait("D:/software/sikulix/cq/tj.PNG", 10);
                                    if(null != match){
                                        match.click();
                                    }
                                }
                                //区组名
                                match = CongQiStart.tjReg.wait("D:/software/sikulix/cq/quzu.PNG", 10);
                                if(null != match){
                                    match.click();
                                    match = CongQiStart.tjReg.wait("D:/software/sikulix/image/ksjr.PNG", 6);
                                    if(null != match){
                                        match.click();
                                        Thread.sleep(5000);
                                        match = CongQiStart.tjReg.wait("D:/software/sikulix/image/qdjr.PNG", 5);
                                        if(null == match){
                                            match = CongQiStart.tjReg.wait("D:/software/sikulix/image/qdjr1.PNG", 2);
                                        }
                                        if(null != match){
                                            match.click();
                                        }
                                        if(null == match){
                                            //如果没进入成功，叉掉重新进入
                                            match = CongQiStart.caReg.wait("D:/software/sikulix/cq/cha.PNG",2);
                                            match.click();
                                            cq();
                                        }
                                    }
                                    Thread.sleep(12000);
                                    match = CongQiStart.tjReg.wait("D:/software/sikulix/image/ksjr.PNG", 5);
                                    if(null != match){
                                        match.click();
                                        Thread.sleep(5000);
                                        match = CongQiStart.tjReg.wait("D:/software/sikulix/image/qdjr.PNG", 5);
                                        if(null == match){
                                            match = CongQiStart.tjReg.wait("D:/software/sikulix/image/qdjr1.PNG", 2);
                                        }
                                        if(null != match){
                                            match.click();
                                        }
                                    }
                                }
                            }
                        }
                        Match xia1 = CongQiStart.tjReg.wait("D:/software/sikulix/cq/rw.PNG", 2);
                        if(null != xia1){
                            //移动文件到指定位置
                            xia1.hover();
                            Thread.sleep(500);
                            //按下左键
                            CongQiStart.tjReg.mouseDown(Button.LEFT);
                            Match xia = CongQiStart.tjReg.wait("D:/software/sikulix/cq/dn.PNG", 2);
                            Location location = xia.getTarget();
                            location.setX(location.getX()+58);
                            location.setY(location.getY()-30);
                            //将鼠标指针移动到指定位置
                            CongQiStart.tjReg.mouseMove(location);
                            Thread.sleep(500);
                            //松开左键
                            CongQiStart.tjReg.mouseUp(Button.LEFT);

                            Thread.sleep(3000);
                            match = CongQiStart.cqReg.wait("D:/software/sikulix/cq/xsstart.PNG", 3);
                            if(null != match){
                                match.click();
                            }
                            wait = CongQiStart.cqReg.wait("D:/software/sikulix/cq/qdcx.PNG", 6);
                            if(null != wait){
                                wait.click();
                            }
                        }else {
                            //如果没进入成功，叉掉重新进入
                            match = CongQiStart.caReg.wait("D:/software/sikulix/cq/cha.PNG",2);
                            if(null != match){
                                match.click();
                            }
                            System.out.println("重新进入失败！！！！！！！！！！！！");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
