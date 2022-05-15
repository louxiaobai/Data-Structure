package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lqw
 * @date 2021/9/21-4:58 下午
 */
public interface UserMapper {

        @Select("select * from user")
        List<User> getUsers();

        //方法存在多个参数,所有的参数前面必须加上@Param("id")
        @Select("select * from user where id=#{id} ")
        User getUserByID(@Param("id") int id);

        @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
        int addUser(User user);



}
