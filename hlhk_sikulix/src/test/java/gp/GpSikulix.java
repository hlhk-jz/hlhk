package gp;
import org.sikuli.basics.Settings;
import org.sikuli.script.Button;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GpSikulix {
    //初始数值
    static double sd = 10.2;

    public static void main(String[] args)throws Exception{
        //获取数值区域
        Region region = new Region(1, 71,133,41);
        region.setThrowException(false);
        //控制台区域
        Region region2 = new Region(621, 895,671,90);
        region2.setThrowException(false);
        //发送区域
        Region region3 = new Region(31, 918,360,69);
        region3.setThrowException(false);
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Settings.MinSimilarity=0.99;
        while (true){
            //获取文本
            String text = region.text();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                //获取数值
                String num = matcher.group();
                double i = Double.valueOf(num);
                //加百分之十后值
                double s = sd/100*110;
                double result = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                //减少百分之五后值
                double m = sd/100*95;
                double result2 = new BigDecimal(m).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                if(i>result || i<result2 ){
                    String sys = result+"*"+result2+"*"+i;
                    System.out.println(" "+sys+"  @@@");
                    //获取 @@@
                    Match wait = region2.wait("D:/ruanjianthree/sikuliide/img/tes.png", 1);
                    //获取左侧web图标
                    Match wait2 = region2.wait("D:/ruanjianthree/sikuliide/img/web.png", 1);
                    if(null != wait){
                        wait.setX(wait.getX()-25);
                        Thread.sleep(500);
                        wait.hover();
                        Thread.sleep(500);
                        //按左键
                        region.mouseDown(Button.LEFT);
                        wait.setX(wait2.getX()+70);
                        Thread.sleep(500);
                        //移动指定位置
                        region.mouseMove(wait.getTarget());
                        Thread.sleep(500);
                        //复制
                        region.type("c" , Key.CTRL);
                        Thread.sleep(500);
                        //释放左键
                        region.mouseUp(Button.LEFT);
                    }
                    Thread.sleep(500);
                    //滚轮向下
                    region.wheel(1,3);
                    Thread.sleep(3000);
                    region3.click();
                    //粘贴
                    region.type("v" , Key.CTRL);
                    Thread.sleep(2000);
                    //发送
                    region.type(Key.ENTER);
                }else {
                    System.out.println("未满足条件！！！！");
                }
            }
            Thread.sleep(5000);
        }
    }
}
