package com.lou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lou.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author lqw
 * @date 2022/3/10-7:50 下午
 */

//在对应的Mapper上面基本的类BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {

    //所有的curd已经写好了
    //你不需要想以前一样配置一大堆的文件了


}
