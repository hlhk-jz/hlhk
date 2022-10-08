package com.util;
import com.pojo.Stu;
import java.util.ArrayList;
import java.util.List;

public class PojoUtils {
    public static List<Stu> getStus() {
        List<Stu> stus = new ArrayList<>();
    /*    Stu stu = new Stu();
        stu.setAge("11");
        stu.setHome("11");
        stu.setName("11");
        stus.add(stu);*/
        Stu stu1 = new Stu();
        stu1.setAge("22");
        stu1.setHome("22");
        stu1.setName("22");
        stus.add(stu1);
        return stus;
    }
}
