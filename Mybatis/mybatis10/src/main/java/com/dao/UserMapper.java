package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/10-7:41 ����
 */
public interface UserMapper {

    //����id��ѯ�û���
    User queryUsers(@Param("id") int id);



}
