package cesi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//按键相关操作
public class AnJianTest extends JFrame implements KeyListener {
    public static void main(String[] args){
       new AnJianTest();
    }

    public AnJianTest(){
        //设置界面大小
        this.setSize(603,680);

        //设置标题
        this.setTitle("拼图小游戏 V1.0");

        //设置永远置顶
        this.setAlwaysOnTop(true);

        //设置程序随着窗口关闭而结束运行
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(3);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //取消默认放置位置
        this.setLayout(null);

        //绑定键盘监听事件
        this.addKeyListener(this);

        //设置界面可视化
        this.setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按住不松开");
        char c = e.getKeyChar();
        int code = e.getKeyCode();
        System.out.println(c);
        System.out.println(code);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
    }
}
