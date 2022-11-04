package com;

import java.nio.channels.Channel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test2 {
    public static void main(String[] args)throws Exception{
   /*  String str = "我是Er Snp";
     System.out.println(str.replace(" ","" ).toUpperCase());*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String str = "2099-01-01 00:00:00";
        Calendar instance = Calendar.getInstance();
        instance.setTime(format.parse(str ));


        instance.add(Calendar.MONTH,8 );

        System.out.println(format.format(instance.getTime()));

    }
}
