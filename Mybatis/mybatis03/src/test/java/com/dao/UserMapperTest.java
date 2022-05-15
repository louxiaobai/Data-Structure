package com.dao;

import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/21-5:22 下午
 */
public class UserMapperTest {


    @Test
    public void getUserById(){

        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(2);

        System.out.println(user);

        sqlSession.close();


    }


}