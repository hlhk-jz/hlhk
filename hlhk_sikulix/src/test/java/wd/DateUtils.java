package wd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args){
        SwingUtilities.invokeLater(
                        new Runnable(){
                            public void run(){
                                new MainFrame();
                            }
                        }
         );
    }
}

class MainFrame extends JFrame implements Runnable, WindowListener {
    private static final long serialVersionUID = 8112161040327127271L;
    //设置时间前面描述
    /*    private JLabel nowLabel = new JLabel("时间:");*/
    private JLabel timeLabel = new JLabel();
    private SimpleDateFormat sdf = null;
    private Thread timer = null;
    private boolean go;

    public MainFrame() {
        sdf = new SimpleDateFormat("HH:mm:ss");
        go = true;
        createGUI();
        addWindowListener(this);
        timer = new Thread(this);
        timer.start();
    }

    private void createGUI() {
        this.setLayout(null);
        //设置字体“dialog”代表字体，1代表样式(1是粗体，0是平常的）15是字号
        timeLabel.setFont(new java.awt.Font("Dialog", 1, 16));
        //设置颜色
        timeLabel.setForeground(Color.red);
        //添加时间前面描述
       /*  this.add(nowLabel);
         nowLabel.setBounds(10, 10, 70, 20);*/
        this.add(timeLabel);
        //设置时间在控件中位置已经宽高
        timeLabel.setBounds(27, 10, 120, 20);
        //设置控件宽高
        this.setSize(140, 80);
        //设置是否可以调节控件大小
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void run() {
        while (go) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                timeLabel.setText(sdf.format(new Date()));
            }
        }
        go = false;
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

