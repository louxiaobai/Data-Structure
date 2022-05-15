package com.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lqw
 * @date 2021/10/25-8:33 ����
 */
public class User {


    String name;

    public String getName() {
        return name;
    }

    @Value("������")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}