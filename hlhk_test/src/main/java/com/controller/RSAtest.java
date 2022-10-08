package com.controller;
import com.config.EncryptionDecryptionUtils;
import com.config.SecretKeyUtils;
import java.security.*;
public class RSAtest {
    public static void main(String[] args) {
        // 加密密文
        String input = "key=85CD019515D14B91AD942787532314FF&startTime=1629431243245&endTime=1660967243244";
        // 生成密钥对文件,在实际开发中，根据实际需求生成文件位置
        String pubPath = "pub.key";
        String priPath = "pri.key";

        /**
         * 生成公钥和私钥文件方法，如果用代码生成，
         * 放开该方法，如果从网上获取直接写到对应文件
         * 中并注释该方法即可
         */
        //SecretKeyUtils.generateKeyPair(pubPath, priPath);

        // 从文件中加载密钥
        PublicKey publicKey = SecretKeyUtils.loadPublicKeyFromFile(pubPath);
        PrivateKey privateKey = SecretKeyUtils.loadPrivateKeyFromFile(priPath);

        // 公钥加密，私钥解密
        String encrypted = EncryptionDecryptionUtils.encryptByAsymmetric(input, publicKey);
        String decrypt = EncryptionDecryptionUtils.decryptByAsymmetric(encrypted, privateKey);
        System.out.println("非对称RSA-公钥加密:" + encrypted);
        System.out.println("非对称RSA-私钥解密:" + decrypt);

        System.out.println("\n==============================================\n");

        // 私钥加密，公钥解密
        String encrypted2 = EncryptionDecryptionUtils.encryptByAsymmetric(input, privateKey);
        String decrypt2 = EncryptionDecryptionUtils.decryptByAsymmetric(encrypted2, publicKey);
        System.out.println("非对称RSA-私钥加密:" + encrypted2);
        System.out.println("非对称RSA-公钥解密:" +decrypt2 );
    }
}
