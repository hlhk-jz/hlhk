package gp;
import org.sikuli.script.Key;
import org.sikuli.script.Region;




public class GpTest {
    //初始数值
    public static double sd = 10.2;
    //加百分之十后值
    public static int zjNum = 110;
    //获取数值区域
    public static Region FIND_REG = new Region(136,180,91,24);
    //发送区域
    public static Region SEND_REG = new Region(72,869,186,58);
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
