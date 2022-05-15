package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:08 下午
 */
public interface TeacherMapper {


    //获取指定老师下的所有有信息以老师的信息

    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);


}
