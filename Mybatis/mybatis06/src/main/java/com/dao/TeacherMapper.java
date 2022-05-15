package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lqw
 * @date 2021/9/27-9:08 обнГ
 */
public interface TeacherMapper {

    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);

}
