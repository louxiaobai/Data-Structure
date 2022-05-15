package com.mapper;

import com.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/2-4:51 下午
 */
public class UserMapperIml implements UserMapper {


    //我们的所有操作,都使用sqlSession来执行（原来的时候）,现在都使用SqlSessionTemplate

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUser();

    }
}