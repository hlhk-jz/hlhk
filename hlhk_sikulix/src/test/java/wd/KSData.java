package wd;

import org.sikuli.script.Region;

public class KSData {
   /* public static void main(String[] args)throws Exception{
        Region region = new Region(1800, 0);
        region.hover();
    }*/
    //继续
    public static String STR = "D:/software/sikulix/wd/wd.PNG";
    //即将结束
    public static String DATA = "D:/software/sikulix/wd/data.PNG";
    //右侧标识
    public static String sikpng = "D:/software/sikulix/wd/sik.PNG";
    public static Region regionData = new Region(1308, 0,612,548);

    public static Region region1 = new Region(1233, 0,471,121);
    public static Region region2 = new Region(1323, 98,470,121);
    public static Region region3 = new Region(1414, 185,484,137);
    public static Region region4 = new Region(1534, 279,386,138);
    public static Region region5 = new Region(1626, 382,294,224);
    static {
        regionData.setThrowException(false);
        region1.setThrowException(false);
        region2.setThrowException(false);
        region3.setThrowException(false);
        region4.setThrowException(false);
        region5.setThrowException(false);
    }
}
