package com;

import lombok.Data;

import java.io.Serializable;
@Data
public class Student  implements Serializable {
    private String name;
    private String age;
    private Integer sex;
}
