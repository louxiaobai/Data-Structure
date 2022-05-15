package com.dao;

import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/21-5:22 ����
 */
public class UserMapperTest {


    @Test
    public void getUserById(){

        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(2);

        System.out.println(user);

        sqlSession.close();


    }


}