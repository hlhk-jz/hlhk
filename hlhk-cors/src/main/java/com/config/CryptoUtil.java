package com.config;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Description: 配合前端CryptoJS实现加密、解密工作。
 * CryptoJS 是一个 JavaScript 库，提供了一系列密码学函数和工具，用于加密、解密、生成摘要等任务。
 * 它支持多种加密算法，包括常见的对称加密算法（如 AES、DES）和非对称加密算法（如 RSA）。
 */
public class CryptoUtil {

    //秘钥和偏移量，要和前端一样
    private final static String IV = "a3c6g5h4v9sss3v5";
    private final static String KEY = "a15q8f6s5s1a2v3s";

    /**
     * 加密算法，使用默认的IV、KEY
     * @param content
     * @return
     */
    public static String encrypt(String content){
        return encrypt(content,KEY,IV);
    }

    /**
     * 解密算法，使用默认的IV、KEY
     * @param content
     * @return
     */
    public static String decrypt(String content){
        return decrypt(content,KEY,IV);
    }
    /**
     * 加密方法
     * @param content
     * @param key
     * @param iv
     * @return
     */
    public static String encrypt(String content, String key, String iv){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = content.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new Base64().encodeToString(encrypted);
        }catch (Exception e) {
            throw new RuntimeException("加密算法异常 CryptoUtil encrypt()加密方法，异常信息：" + e.getMessage());
        }
    }

    /**
     * 解密方法
     * @param content
     * @param key
     * @param iv
     * @return
     */
    public static String decrypt(String content, String key, String iv){
        try {
            byte[] encrypted1 = new Base64().decode(content);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original).trim();
        } catch (Exception e) {
            throw new RuntimeException("加密算法异常 CryptoUtil decrypt()解密方法，异常信息：" + e.getMessage());
        }
    }
}
