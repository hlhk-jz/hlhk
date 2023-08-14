package gp;
import org.sikuli.basics.Settings;
import org.sikuli.script.Button;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
public class GpSikulix {
    public static void main(String[] args)throws Exception{
        //获取数值区域
        Region region = new Region(11, 269,155,54);
        region.setThrowException(false);
        //控制台区域
        Region region2 = new Region(677, 849,695,144);
        region2.setThrowException(false);
        //发送区域
        Region region3 = new Region(28, 415,221,105);
        region3.setThrowException(false);
        Settings.MinSimilarity=0.99;
        while (true){
            //获取文本
            String text = region.text();
            System.out.println("test:"+text+"  @@@ "+System.currentTimeMillis()/1000);
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
            Thread.sleep(290000);
        }
    }
}
