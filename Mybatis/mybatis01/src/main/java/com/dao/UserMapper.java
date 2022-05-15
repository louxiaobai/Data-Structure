package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/9/21-4:58 下午
 */
public interface UserMapper {

        //查询全部用户
        List<User> getUserList();
        //根据id查询用户
        User getUserById(int id );

        //进行模糊查询

        List<User> getUser(String name);

        //插入一个用户
        int addUser(User user);
        //万能的map--添加用户
        int addUser2(Map<String,Object> map);

        //修改一个用户
        int updateUser(User user);
        //删除一个用户
        int deleteUser(int id);


}
