package com.dao;

import com.pojo.Student;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:17 ÏÂÎç
 */
public class MyTest {


    @Test
    public void testStudent(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent();

        for (Student student : students) {
            System.out.println(student);

        }
        sqlSession.close();


    }

    @Test
    public void testStudent2(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent2();


        for (Student student : students) {
            System.out.println(student);

        }

        sqlSession.close();


    }

}