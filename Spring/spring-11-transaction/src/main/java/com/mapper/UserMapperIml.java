package com.mapper;

import com.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author lqw
 * @date 2021/11/2-4:51 下午
 */
public class UserMapperIml extends SqlSessionDaoSupport implements UserMapper {


    //我们的所有操作,都使用sqlSession来执行（原来的时候）,现在都使用SqlSessionTemplate

    public List<User> selectUser() {

        User user = new User(12, "狗蛋", "32");

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