package com.dao;

import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * @author lqw
 * @date 2021/9/21-5:22 ����
 */
public class UserMapperTest {
    @Test
    public  void test(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //�ײ���ҪӦ�÷���
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(6,"����","123"));
        sqlSession.close();


    }



}