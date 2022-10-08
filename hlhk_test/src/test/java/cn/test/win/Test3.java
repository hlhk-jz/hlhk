package cn.test.win;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Test3 {
    public static void main(String[] args){
        //模拟按下空格按键
       // pressSingleKeyByNumber(KeyEvent.VK_SPACE);

        //鼠标指定位置左键单机
        clickScreenByXY(42,430);

        pressMultipleKeyByNumber(KeyEvent.VK_COPY,KeyEvent.VK_PASTE);
    }

    /**
     * 按下组合键，如 ctrl + c、ctrl + v、alt + tab 等等
     *
     * @param keycode：组合健数组，如 {KeyEvent.VK_CONTROL,KeyEvent.VK_V}
     */
    public static void pressMultipleKeyByNumber(int... keycode) {
        try {
            Robot robot = new Robot();

            //按顺序按下健
            for (int i = 0; i < keycode.length; i++) {
                robot.keyPress(keycode[i]);
                robot.delay(50);
                robot.keyRelease(keycode[i]);
                robot.delay(50);
            }

            //按反序松开健
           /* for (int i = keycode.length - 1; i >= 0; i--) {
                robot.keyRelease(keycode[i]);
                robot.delay(50);
            }*/
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟用户单击屏幕指定区域,默认单击屏幕最中央
     * 如果是右键，请使用：InputEvent.BUTTON3_DOWN_MASK
     * @param x：x坐标
     * @param y：y坐标
     */
    public static final void clickScreenByXY(Integer x, Integer y) {
        try {
            /**创建工具包对象*/
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            /**创建自动化对象*/
            Robot robot = new Robot();
            /**利用工具包对象获取屏幕分辨率*/
            if (x == null) {
                x = toolkit.getScreenSize().width / 2;
            }
            if (y == null) {
                y = toolkit.getScreenSize().height / 2;
            }
            /**
             * 移动鼠标到指定位置
             * 然后按下鼠标左键，再松开，模拟单击操作
             */
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟按下键盘单个按键，比如文档下一页：PgDn，上一页是PgUp等
     *
     * @param keycode：按键的值,如：KeyEvent.VK_PAGE_UP
     */
    public static final void pressSingleKeyByNumber(int keycode) {
        try {
            /** 创建自动化测试对象  */
            Robot robot = new Robot();
            /**可以稍作延时处理,类似睡眠 ms毫秒*/
            robot.delay(4000);
            /**按下按键*/
            robot.keyPress(keycode);
            /**松开按键*/
            robot.keyRelease(keycode);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
