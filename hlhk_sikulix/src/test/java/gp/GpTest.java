package gp;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
public class GpTest {
    //初始数值
    public static double sd = 15.34;
    //加百分之十后值
    public static int zjNum = 108;
    //获取数值区域
    public static Region FIND_REG = new Region(23,261,92,45);
    //发送区域
    public static Region SEND_REG = new Region(155,931,168,42);
    static {
        FIND_REG.setThrowException(false);
        SEND_REG.setThrowException(false);
    }

    public static void main(String[] args)throws Exception{
        //获取数值
        String text = FIND_REG.text();
        double i = Double.valueOf(text.replace(" ", ""));
        SEND_REG.click();
        Thread.sleep(1000);
        SEND_REG.type(i+"");
        SEND_REG.type(Key.ENTER);
    }
}
