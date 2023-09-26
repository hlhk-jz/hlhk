package com;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args){
       String str = "http://www.quanzhifashi.com/bookcase";
        boolean matches = Pattern.matches("\\d+", str);
        System.out.println(matches);
    }
}
