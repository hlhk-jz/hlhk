package com.config;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
/**
 *  AES加密
 */
public class DesUtils {
    // 算法名称
    private static final String KEY_ALGORITHM = "AES";
    // 填充方式 = PKCS5Padding 加密的数据会自动帮我们填充
    //private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
    //填充方式 =NoPadding 不填充，那么加密的数据的.getBytes.lenth 就必须是8的倍数，否则会报错
    private static final String CIPHER_ALGORITHM = "AES/ECB/NoPadding";
    /**加密*/
    public static String encrypt(String data,String key) throws Exception {
        //创建秘钥
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        //SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey=new SecretKeySpec(key.getBytes(), "AES");
       // SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        //加密
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] result = cipher.doFinal(data.getBytes());
        //使用base64进行编码
        return Base64.getEncoder().encodeToString(result);
    }
    /**解密*/
    public static String decrypt(String data,String key) throws Exception {
        //使用base64进行解码
        byte[] bs = Base64.getDecoder().decode(data);
        //创建秘钥
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        /*SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);*/
        SecretKey secretKey=new SecretKeySpec(key.getBytes(), "AES");
        //解密
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] result = cipher.doFinal(bs);
        return new String(result);
    }
}
