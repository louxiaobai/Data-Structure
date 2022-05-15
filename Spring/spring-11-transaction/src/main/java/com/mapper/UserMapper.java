package com.mapper;

import com.pojo.User;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/27-9:17 下午
 */
public interface UserMapper {
    //查询所有用户
    public List<User> selectUser();

    //添加一个用户

    public int addUser(User user);

    //删除一个用户

    public  int deleteUser(int id);


}
