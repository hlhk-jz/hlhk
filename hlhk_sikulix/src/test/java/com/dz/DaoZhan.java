package com.dz;
import org.sikuli.basics.HotkeyEvent;
import org.sikuli.basics.HotkeyListener;
import org.sikuli.script.Env;
import org.sikuli.script.Key;
import org.sikuli.script.Region;

//道战
public class DaoZhan {
    public static void main(String[] args)throws Exception{
        Env.addHotkey(Key.F4,  0, new ListenerTest());
    }
}

class ListenerTest extends HotkeyListener {
    public  Region region = new Region(0,0 ,1920 ,1080 );
    @Override
    public void hotkeyPressed(HotkeyEvent hotkeyEvent) {
        region.type(Key.F5 );
    }
}
