package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/9/21-4:58 ����
 */
public interface UserMapper {

        //��ѯȫ���û�
        List<User> getUserList();
        //����id��ѯ�û�
        User getUserById(int id);

        //����һ���û�
        int addUser(User user);

        //�޸�һ���û�
        int updateUser(User user);
        //ɾ��һ���û�
        int deleteUser(int id);


}
