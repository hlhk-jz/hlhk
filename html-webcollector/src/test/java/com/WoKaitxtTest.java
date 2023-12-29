package com;

import java.io.*;

public class WoKaitxtTest {
    public static void main(String[] args)throws Exception{
        InputStreamReader isr=new InputStreamReader(new FileInputStream(new File("D:/sd.txt")),"UTF-8");//选择编码方式，避免乱码
        BufferedReader read=new BufferedReader(isr);//写入数据流方式
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("D:/ss.txt"),"UTF-8");//选择编码方式，避免乱码
        BufferedWriter write=new BufferedWriter(osw);//写入数据流方式
        String string = "";
        int i=0;//新建行号的符号i
        while((string = read.readLine())!= null) {//readLine()方法,要读取的一行内容不为空就一直执行
            if(string.replace(" ","" ).equals("")) {//if条件语句
                continue;//该行为空时不进行任何操作
            }

            else {//否则
                i++;
                //	write.write("["+i+"]");//可在文档中标出行号(有需要时可以取消该注释)
                write.write(string.replace("　　","" )+"\r\n");//在新文档中写入指定内容
            }
        }
        write.close();//关闭流
        read.close();//关闭流
    }
}
