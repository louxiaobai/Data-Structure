package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/10-7:41 下午
 */
public interface UserMapper {

    //根据id查询用户数
    User queryUsers(@Param("id") int id);



}
