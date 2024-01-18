package com;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjetInputstreama {
    public static void main(String[] args)throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/d.txt")) ;
        Student student = (Student)objectInputStream.readObject();
        System.out.println(student);
    }
}
