package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args){
        String str1 = "http://www.xfuedu.org/bxwx/28340/4084664.html#";
        String str2 = "http://www.xfuedu.org/bxwx/28340/4084664.html";
       if(str2.contains(str1)){
           System.out.println("包含");
       }else {
           System.out.println("不包含");
       }
    }
}
