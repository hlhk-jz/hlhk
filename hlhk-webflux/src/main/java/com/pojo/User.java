package com.pojo;

import lombok.Data;

@Data
public class User {
    private String userNam;
    private String age;
    private String userId;

    public User(String userName,String age,String userId){
        this.userNam = userName;
        this.age = age;
        this.userId = userId;
    }
}
