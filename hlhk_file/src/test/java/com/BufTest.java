package com;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * BufferedInputStream 是对 inputstream 进行包装，增加缓存的功能，本身并没有读写的能力
 * 提升效率应该是只对 read() 方法进行提升，如果 FileInputStream 的 read(byte[]) 其实没
 * 太大提升， read() 是一个字节一个字节进行读写，所以 buf 有个固定大小的缓存对象先往
 * 那里面读写，满了在从缓存对象中取
 */
public class BufTest {
    public static void main(String[] args)throws Exception{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:/filetest/a.txt"));
        FileInputStream fileInputStream = new FileInputStream("D:/filetest/a.txt");
        byte[] n = new byte[1024];
        int read = fileInputStream.read(n);
        int read1 = bufferedInputStream.read(n);
        // byte[] b = new byte[100];
        int len;
        while ((len = bufferedInputStream.read()) != -1) {
            System.out.println(len);
        }

    }
}
