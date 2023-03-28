package com;

import org.sikuli.script.Match;
import org.sikuli.script.Region;

//远程协助确认
public class YcxzStart {
    public static void main(String[] args){
            Region region = new Region(1445, 740,475,315);
            region.setThrowException(false);
            while (true){
                try {
                    Match wait = region.wait("D:/software/sikulix/image/ycxz.PNG", 30);
                    if(null != wait){
                        wait.click();
                    }
                } catch (Exception e) {
                e.printStackTrace();
            }
           }

    }
}
