package cn.test;

import cn.hutool.poi.excel.ExcelFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.*;
import org.springframework.web.context.support.ServletContextResource;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Slf4j
public class Test5 {
    public static void main(String[] args)throws Exception{
        String str = "abcdwwww";
        int length = str.getBytes().length;
        log.info("======= "+length);

     /*   FileSystemResource fileSystemResource = new FileSystemResource("D:/a.xlsx");
        File file = fileSystemResource.getFile();
        InputStream inputStream = fileSystemResource.getInputStream();*/



       /* Resource classPathResource = new ClassPathResource("a.xlsx");
        File file = classPathResource.getFile();*/


      /*  UrlResource urlResource = new UrlResource(new URI("http://localhost:9002/test2"));
        log.info("=========="+urlResource.getInputStream());
        DataInputStream dataInputStream = new DataInputStream(urlResource.getInputStream());
        byte[] chars = new byte[122];
        int i = 0;
        while ((i=dataInputStream.read(chars)) != -1){
            log.info("读取数量："+i);
            String str = new String(chars);
            log.info("============ "+str);
        }*/

       /* UrlResource urlResource = new UrlResource(new URI("file:///D:/a.png"));

        log.info(""+urlResource.getFilename());
        log.info(""+urlResource.getDescription());

        InputStream inputStream = urlResource.getInputStream();
        byte[] bytes = new byte[1011];
        OutputStream outputStream = new FileOutputStream("D://c.png");
        while (inputStream.read(bytes) != -1){
            System.out.println("11111111111======"+inputStream.available());
            outputStream.write(bytes);
        }
        inputStream.close();
        outputStream.close();*/
    }
}
