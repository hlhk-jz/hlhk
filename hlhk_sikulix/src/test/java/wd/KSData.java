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

    public static Region region1 = new Region(1241, 7,496,92);
    public static Region region2 = new Region(1404, 107,366,97);
    public static Region region3 = new Region(1421, 201,372,102);
    public static Region region4 = new Region(1604, 294,304,111);
    public static Region region5 = new Region(1694, 404,226,119);
    static {
        regionData.setThrowException(false);
        region1.setThrowException(false);
        region2.setThrowException(false);
        region3.setThrowException(false);
        region4.setThrowException(false);
        region5.setThrowException(false);
    }
}
