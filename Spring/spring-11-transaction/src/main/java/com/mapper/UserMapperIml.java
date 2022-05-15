package com.mapper;

import com.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/2-4:51 ����
 */
public class UserMapperIml extends SqlSessionDaoSupport implements UserMapper {


    //���ǵ����в���,��ʹ��sqlSession��ִ�У�ԭ����ʱ��,���ڶ�ʹ��SqlSessionTemplate

    public List<User> selectUser() {

        User user = new User(12, "����", "32");

        addUser(user);
        deleteUser(12);

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

        return mapper.selectUser();

    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}