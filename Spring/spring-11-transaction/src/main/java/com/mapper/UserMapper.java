package com.mapper;

import com.pojo.User;

import java.util.List;

/**
 * @author lqw
 * @date 2021/10/27-9:17 ����
 */
public interface UserMapper {
    //��ѯ�����û�
    public List<User> selectUser();

    //���һ���û�

    public int addUser(User user);

    //ɾ��һ���û�

    public  int deleteUser(int id);


}
