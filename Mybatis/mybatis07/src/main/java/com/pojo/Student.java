package com.pojo;

/**
 * @author lqw
 * @date 2021/9/27-9:06 ÏÂÎç
 */
public class Student {


    private int id;
    private String name;

    private int tid;

    public Student() {
    }

    public Student(int id, String name, int tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }
}