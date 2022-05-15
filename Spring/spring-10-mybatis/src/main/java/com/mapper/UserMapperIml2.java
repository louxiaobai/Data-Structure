package com.mapper;

import com.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/2-5:11 обнГ
 */
public class UserMapperIml2 extends SqlSessionDaoSupport implements  UserMapper{
    public List<User> selectUser() {

        SqlSession sqlSession = getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUser();

    }
}