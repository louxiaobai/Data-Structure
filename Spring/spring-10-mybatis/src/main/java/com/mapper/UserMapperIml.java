package com.mapper;

import com.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/2-4:51 ����
 */
public class UserMapperIml implements UserMapper {


    //���ǵ����в���,��ʹ��sqlSession��ִ�У�ԭ����ʱ��,���ڶ�ʹ��SqlSessionTemplate

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUser() {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.selectUser();

    }
}