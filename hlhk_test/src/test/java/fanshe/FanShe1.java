package fanshe;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class FanShe1 {
    public static void main(String[] args){
        try {
            Class<?> aClass = Class.forName("fanshe.FanShePojo");
            //获取公有私有字段
            Field[] fields = aClass.getDeclaredFields();
            log.info("======"+fields.length);
            Arrays.stream(fields).forEach((a)->System.out.print(a.getName()+","));

            System.out.println();
            //获取公有私有方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Arrays.stream(declaredMethods).forEach((a)->System.out.print(a.getName()+","));

            //获取无参构造并创建对象
            Constructor<?> constructor = aClass.getConstructor();
            FanShePojo o =(FanShePojo) constructor.newInstance();
            o.setAge(11111);
            log.info("{}",o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
