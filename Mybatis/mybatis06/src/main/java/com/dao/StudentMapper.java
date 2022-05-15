package com.dao;

import com.pojo.Student;
import com.pojo.Teacher;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:08 下午
 */
public interface StudentMapper {

    //查询所有的学信息,以及对应的老师的信息
    public List<Student> getStudent();

    public List<Student> getStudent2();



}
