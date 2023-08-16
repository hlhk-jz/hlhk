/*
package cn.test;
import cn.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

*/
/**将地址生成二维码*//*

@Slf4j
public class ImageTest {
    public static void main(String[] args)throws Exception{
        String url = "http://www.baidu.com";
        BufferedImage image = QRCodeUtil.createImage("utf-8", url, 300, 300);
       */
/* QRCodeUtil.addUpFont(image, "扫码支付(180S)");
        QRCodeUtil.addBottomFont(image,"请用手机微信或支付宝扫码完成支付",1);*//*

     */
/*   File file = new File("D:/jar/a.jpg");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        ImageIO.write(image, "JPEG", file);*//*



     //BufferedImage转二进制
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);
        String str = Base64.getEncoder().encodeToString(stream.toByteArray());
        log.info("========== "+str);
    }
}
*/
