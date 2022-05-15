package com.dao;

import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


/**
 * @author lqw
 * @date 2021/9/21-5:22 下午
 */
public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);
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

    @Test
    public void getUserByLimit(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map= new HashMap<String, Integer>();

        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {

            System.out.println(user);

        }


        sqlSession.close();


    }



    @Test
    public void testLog4J(){

        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }


}