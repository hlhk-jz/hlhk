package cn.java8;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Slf4j
public class HlhkTest {
    public static void main(String[] args){
        log.info("====="+RandomUtil.randomNumber());
        List<ComStu2> stus = new ArrayList<>();
        ComStu2 stu = new ComStu2();
        stu.setAge(RandomUtil.randomNumber()+"");
        stu.setName("zhangsan");
        stus.add(stu);
        ComStu2 stu1 = new ComStu2();
        stu1.setAge(RandomUtil.randomNumber()+"");
        stu1.setName("wangwu");
        stus.add(stu1);
        ComStu2 stu2 = new ComStu2();
        stu2.setAge(RandomUtil.randomNumber()+"");
        stu2.setName("zhaoliu");
        stus.add(stu2);
        ComStu2 stu3 = new ComStu2();
        stu3.setAge(RandomUtil.randomNumber()+"");
        stu3.setName("heihei");
        stus.add(stu3);
        log.info("排序前：{}",stus);
        Collections.sort(stus, new Comparator<ComStu2>() {
            @Override
            public int compare(ComStu2 o1, ComStu2 o2) {
                //正序
               // return o1.getAge().compareTo(o2.getAge());
                //倒叙
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        log.info("排序后：{}",stus);
    }
}
