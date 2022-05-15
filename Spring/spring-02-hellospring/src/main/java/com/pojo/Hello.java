package com.pojo;

/**
 * @author lqw
 * @date 2021/10/14-8:11 обнГ
 */
public class Hello {

    private String str;

    public Hello() {
    }

    public Hello(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}