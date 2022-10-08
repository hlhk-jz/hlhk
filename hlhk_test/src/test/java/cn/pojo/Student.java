package cn.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 班级
     */
    private String className;
    /**
     * 所在省
     */
    private String province;
    /**
     * 学号
     */
    private Integer stuNo;
    /**
     * 入学成绩
     */
    private Double score;

    public Student(Integer id, String name, Integer age, String className, String province, Integer stuNo, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
        this.province = province;
        this.stuNo = stuNo;
        this.score = score;
    }
    public Student(){}
}