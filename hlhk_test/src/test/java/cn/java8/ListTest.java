package cn.java8;

import cn.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ListTest {
    private List<Student> buildStudentList() {
        return Arrays.asList(new Student(1, "张扬", 18, "A", "北京", 45, 83.2),
                new Student(2, "李丹", 22, "A", "天津", 15, 65.5),
                new Student(3, "张丹", 22, "B", "山东", 44, 78.4),
                new Student(4, "白天", 19, "B", "北京", 1, 63.7),
                new Student(5, "王武", 20, "C", "湖南", 34, 78.3)
        );
    }

    //将pojo中的某个属性用逗号，拼接
    @Test
    public void join(){
        List<Student> students = buildStudentList();
        String collect = students.stream().map(Student::getName).collect(Collectors.joining(","));
        log.info("=========== "+collect);
    }

    @Test
    public void toMap(){
        List<Student> students = buildStudentList();
        //list 转 map，如果有重复的键，保留前一个
        Map<Integer, Student> collect = students.stream().collect(Collectors.toMap(Student::getId, Function.identity(), (s, a) -> s));
        log.info("======== "+collect);
    }

    //按 班级 分组
    @Test
    public void groupbyTest(){
        List<Student> students = buildStudentList();
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getClassName));
        log.info("========== "+collect.keySet());
    }

    /**
     * 分组统计
     * DoubleSummaryStatistics 该类是对数值的统计对象
     */
    @Test
    public void stuStatistics(){
        List<Student> students = buildStudentList();
        Map<String, IntSummaryStatistics> collect = students.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors.summarizingInt(Student::getAge)));
        log.info("================ "+collect);
        for (String key : collect.keySet()){
            log.info(key+" 组的年龄总和为："+collect.get(key).getSum());
        }
    }


    //总和
    @Test
    public void summingDoubleExample() {
        List<Double> list = Arrays.asList(1.0, 2.2, 3.3, 4.4);
        Double sum = list.stream().collect(Collectors.summingDouble(i -> {
            return i;
        }));
        System.out.println(sum);
    }

    /**
     * 去重
     */
    @Test
    public void stuSet() {
        List<Student> students = buildStudentList();
        ArrayList<Student> list = students.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getProvince))), ArrayList::new));
        //结果：[Student(id=1, name=张扬, age=18, className=A, province=北京, stuNo=45, score=83.2), Student(id=2, name=李丹, age=22, className=A, province=天津, stuNo=15, score=65.5), Student(id=3, name=张丹, age=22, className=B, province=山东, stuNo=44, score=78.4), Student(id=5, name=王武, age=20, className=C, province=湖南, stuNo=34, score=78.3)]
        System.out.println(list);
    }


}
