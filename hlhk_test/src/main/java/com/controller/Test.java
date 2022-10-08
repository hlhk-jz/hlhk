package com.controller;
import com.config.DesUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Test {
    public static void main(String[] args)throws Exception{
        //加密的数据如果是NoPadding不填充，那么数据.getBytes.lenth 就必须是8的倍数
        String str = "@@@@########@@@@";
        //加解密用到的秘钥-getBytes().length即字节的长度必须大于等于8
        String key = "#!@!@@@@#!@!@@@@";
        log.info("加密前======= "+str);
        String hello = DesUtils.encrypt(str,key);
        log.info("加密后======= "+hello);
        String decrypt = DesUtils.decrypt(hello,key);
        log.info("解密后===="+decrypt);
    }
}
