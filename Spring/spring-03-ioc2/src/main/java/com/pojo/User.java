package com.pojo;

/**
 * @author lqw
 * @date 2021/10/14-9:01 ����
 */
public class User {

    private String name;

//    public User() {
//
//        System.out.println("User���޲ι���");
//    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){

        System.out.println("name"+name);
    }
}