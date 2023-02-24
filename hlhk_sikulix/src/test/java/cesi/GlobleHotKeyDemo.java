package cesi;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 利用JIntellitype实现全局热键设置
 */
public class GlobleHotKeyDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    //定义热键标识，用于在设置多个热键时，在事件处理中区分用户按下的热键
    public static final int FUNC_KEY_MARK = 1;

    public GlobleHotKeyDemo() {

        //第一步：注册热键，第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
        JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK, 0, 65);

        //第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            @Override
            public void onHotKey(int markCode) {
                try {
                    Robot robot = new Robot();
                    switch (markCode) {
                        case FUNC_KEY_MARK:
                            robot.keyPress(KeyEvent.VK_Q);
                            robot.keyPress(KeyEvent.VK_W);
                            robot.keyPress(KeyEvent.VK_E);
                            robot.keyPress(KeyEvent.VK_R);
                            break;
                    }
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        new GlobleHotKeyDemo();
    }
}