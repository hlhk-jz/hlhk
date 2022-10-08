package com.test;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class ReaderTest2 {
    public static void main(String[] args)throws Exception{


   /*   Reader reader = new BufferedReader(new FileReader("D:/a.txt"));
        int read = reader.read();
        log.info("========== "+read);
        reader.close();*/
        /*InputStream inputStream = new FileInputStream("D:/a.txt");
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        OutputStream outputStream = new FileOutputStream("D:/b.txt");
        outputStream.write(bytes);
        outputStream.flush();
        inputStream.close();
        outputStream.close();*/

 /*       InputStream inputStream = new FileInputStream("D:/a.txt");
        OutputStream outputStream = new FileOutputStream("D:/b.txt");
        byte[] bytes = new byte[1023];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        inputStream.close();
        outputStream.close();*/
    }
}
