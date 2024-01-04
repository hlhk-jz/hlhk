package com.pojo;

import lombok.Data;

@Data
public class User {
    public User(String name,String phone){
        this.name = name;
        this.phone = phone;
    }
    private String name;
    private String phone;
}
