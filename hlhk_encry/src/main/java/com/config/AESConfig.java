package com.config;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESConfig {
    public static void main(String[] args){
        try {
           // getData();
            System.out.println( getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getKey()throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 支持 128、192、256 位密钥
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getFormat();
    }
    public static String getData()throws Exception{
        // 生成 AES 密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 支持 128、192、256 位密钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 创建 AES Cipher 对象
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 随机生成初始向量
        byte[] iv = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // 加密
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        String plaintext = "Hello, World!";
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
        return "";
    }
}
