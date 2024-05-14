package jincheng;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://learn.microsoft.com/zh-cn/windows/win32/api/winuser/nf-winuser-adjustwindowrect
public class Win32 {
    public static void main(String[] args) {

        User32 user32 = User32.INSTANCE;
        WinDef.HWND hwnd = user32.FindWindow(null, "test");




        WinUser.HOOKPROC hookproc = null;
        WinUser.HHOOK hhook = user32.SetWindowsHookEx(2, hookproc,  Kernel32.INSTANCE.GetModuleHandle(null),21772 );
        if(null != hwnd){
            //激活并显示窗口。并且系统会将其还原到其原始大小和位置。
            //user32.ShowWindow(hwnd, 1);
            //将创建指定窗口的线程引入前台
            //boolean b = user32.SetForegroundWindow(hwnd);
        }else {
            System.out.println("未查询到指定信息");
        }



    }
}
