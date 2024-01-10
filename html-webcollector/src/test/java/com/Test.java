package com;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args){
         String str = "第2章";
        int s = str.indexOf("第");
        int s1 = str.indexOf("章");
        str = str.substring(s+1,s1 );
        System.out.println(str);
    }
}
