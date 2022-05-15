package com.lou;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lou.mapper.UserMapper;
import com.lou.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lqw
 * @date 2022/3/13-5:30 下午
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads(){

        //查询到name不为空的用户,并且邮箱不能为空的用户,年龄大于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper
                .isNotNull("name");

        userMapper.selectList(wrapper);


    }



}