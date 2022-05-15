package com.dao;

import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/9/21-5:22 ����
 */
public class UserMapperTest {

    @Test
    public void test(){
        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {

            System.out.println(user);

        }

        //�ر�sqlSession

        sqlSession.close();


    }

    @Test
    public void getUserById(){

        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(1);

        System.out.println(user);

        sqlSession.close();


    }


    @Test
    public void getUser(){

        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.getUser("%��%");

        System.out.println(user);

        sqlSession.close();

    }


    //��ɾ����Ҫ�����ύ����
    @Test
    public void addUser(){
        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res =mapper.addUser(new User(10,"10��","123"));
        if (res>0){
            System.out.println("����ɹ�!");
        }
        //�����ύ����
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){


            //��һ����ȡ��sqlSession����

            SqlSession sqlSession = MyBatisUtils.getSqlSession();


            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String,Object> map=new HashMap<String, Object>();

            map.put("userid", 5);
            map.put("userName", "����");
            map.put("passWord", "123");



            mapper.addUser2(map);

            //�����ύ����
            sqlSession.commit();
            //���йر�����
            sqlSession.close();


        }



    @Test
    public  void updateUser(){

        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //��ʽһ:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int nums = mapper.updateUser(new User(4, "����", "123"));

        if (nums>0){

            System.out.println("�޸ĳɹ�");
        }

        //�����ύ����
        sqlSession.commit();
        sqlSession.close();




    }

    @Test
    public  void deleteUser(){

        //��һ����ȡ��sqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();

        sqlSession.close();
    }


}