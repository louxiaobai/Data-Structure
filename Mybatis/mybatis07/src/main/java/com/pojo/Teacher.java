package com.pojo;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:06 下午
 */
public class Teacher {

    private int id;

    private String name;

    //一个老师可以拥有多个学生

    private List<Student> students;

    public Teacher() {
    }

    public Teacher(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}