package com.dao;

import com.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/27-9:08 ����
 */
public interface TeacherMapper {


    //��ȡָ����ʦ�µ���������Ϣ����ʦ����Ϣ

    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);


}
