package gp;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.Key;
import java.math.BigDecimal;
@Slf4j
public class Gp {
    public static void main(String[] args)throws Exception{
        while (true){
            Thread.sleep(15000);
            try {
                //获取数值
                String text = GpTest.FIND_REG.text();
                double i = Double.valueOf(text.replace(" ", ""));
                //加百分之十后值
                double s = GpTest.sd/100*GpTest.zjNum;
                double result = new BigDecimal(s).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                if(i>result ){
                    GpTest.SEND_REG.click();
                    Thread.sleep(1000);
                    GpTest.SEND_REG.type(GpTest.sd+"  "+i);//发送
                    Thread.sleep(1000);
                    GpTest.SEND_REG.type(Key.ENTER);
                }
            }catch (Exception e){
                log.error("出现异常：{}",e);
            }
        }
    }
}
