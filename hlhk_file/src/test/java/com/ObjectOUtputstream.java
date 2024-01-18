package com;

import java.io.*;

public class ObjectOUtputstream {
    public static void main(String[] args)throws Exception{
      /*  InputStream inputStream = new FileInputStream("D:/d.txt");
        DataInputStream dataInputStream = new DataInputStream(inputStream);*/
        Student student = new Student();
        student.setAge("2");
        student.setName("zzhang");
        student.setSex(23);

        OutputStream outputStream = new FileOutputStream("D:/d.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(student);
        outputStream.close();
        objectOutputStream.close();
    }

}
