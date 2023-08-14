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
        Region region2 = new Region(772, 852,481,120);
        region2.setThrowException(false);
        //发送区域
        Region region3 = new Region(28, 415,221,105);
        region3.setThrowException(false);
        Settings.MinSimilarity=0.99;
        while (true){
            //获取文本
            String text = region.text();
            System.out.println("test:"+text+" @@@ "+System.currentTimeMillis()/1000);
            Match wait = region2.wait("D:/ruanjianthree/sikuliide/img/tes.png", 1);
            if(null != wait){
                wait.hover();
                Thread.sleep(500);
                //按左键
                region.mouseDown(Button.LEFT);
                wait.setX(wait.getX()-50);
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
            Thread.sleep(2000);
            region3.click();
            //粘贴
            region.type("v" , Key.CTRL);
            Thread.sleep(500);
            //发送
            region.type(Key.ENTER);
            Thread.sleep(100000);
        }
    }
}
