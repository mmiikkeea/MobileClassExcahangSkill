package com.example.mikechen.mobileclass;

/**
 * Created by mikechen on 9/18/15.
 */
public class User {
    String name,password,skill,interest;
    int age;

    public  User(String name,int age,String password,String skill, String interest){
        this.name = name;
        this.age=age;
        this.password=password;
        this.skill=skill;
        this.interest=interest;

    }
    public User(String name, String password){
        this.name=name;
        this.password=password;
        this.age=-1;
    }
}
