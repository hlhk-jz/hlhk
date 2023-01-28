package sikulix;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.*;

import java.util.Iterator;

/**
 * Screen 是屏幕
 * Region 是屏幕上的矩形区域
 */
@Slf4j
public class SikTest {
    public static void main(String[] args)throws Exception{

        /*1. 点击新手地图
        2. 下地图
        3. 随机
        4. 找怪，打怪
        5. 捡去装备
        6. 判断屏幕是否显示背包已满
        6.1 满了回城回收
        6.2 没满继续随机找怪*/

        // 1 点击新手地图
        /* Region region = new Region(0, 0,1920,1080);
        //查找新手图标图片
        Match match = region.find("D:/b.png");
        double score = match.getScore();
        //2. 单机新手图标
        region.click();
        //2. 查找进入地图菜单，并点击下地图
        Match match2 = region.find("D:/c.png");
        double score2 = match2.getScore();
        System.out.println("查找："+score2);
        //3. 随机*/


        //==============分割线======================

         //x,y 默认为 0,0 在最左上角
         Region region = new Region(0, 0,1920,1080);
        //查找图标图片
        Match match = region.find("D:/b.png");
        double score = match.getScore();
        System.out.println("查找相似数量："+score);
        //获取要点击的对象
        Location target = match.getTarget();
        target.doubleClick();


       // Match match1 = region.find("D:/c.png");
       // System.out.println("查找相似数量1："+match1.getScore());
        //操作后需要睡眠会否则下个操作可能会失效
        Thread.sleep(300);
       // Location target1 = match1.getTarget();
      //  target1.click();
        region.type("v",Key.CTRL );
        //双击
        //region.doubleClick();


        //==============分割线======================


        //双击屏幕指定区域，位置获取用工具 location 截取 x,y
      /*Location at = Mouse.at();
        at.set(197, 62);
        at.doubleClick();*/
    }
}
