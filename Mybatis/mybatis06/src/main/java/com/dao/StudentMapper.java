package com.dao;

import com.pojo.Student;
import com.pojo.Teacher;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:08 ����
 */
public interface StudentMapper {

    //��ѯ���е�ѧ��Ϣ,�Լ���Ӧ����ʦ����Ϣ
    public List<Student> getStudent();

    public List<Student> getStudent2();



}
