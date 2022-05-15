package com.dao;

import com.pojo.User;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/21-4:58 下午
 */
public interface UserMapper {


        //根据id查询用户
        User getUserById(int id);


}
