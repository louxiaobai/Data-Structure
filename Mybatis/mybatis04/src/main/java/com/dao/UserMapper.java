package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/9/21-4:58 ����
 */
public interface UserMapper {


        //����id��ѯ�û�
        User getUserById(int id);

        //ʵ�ַ�ҳ����

        List<User> getUserByLimit(Map<String,Integer> map);





}
