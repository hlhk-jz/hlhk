package jincheng;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
//https://learn.microsoft.com/zh-cn/windows/win32/api/winuser/nf-winuser-adjustwindowrect
public class Win32 {
    public static void main(String[] args){

        //获取计算器的窗口句柄
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null,"设置");
        //将窗口带到前台
        User32.INSTANCE.SetForegroundWindow(hwnd);

    }
}
