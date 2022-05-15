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
 * @date 2021/9/21-5:22 下午
 */
public class UserMapperTest {

    @Test
    public void test(){
        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {

            System.out.println(user);

        }

        //关闭sqlSession

        sqlSession.close();


    }

    @Test
    public void getUserById(){

        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        User user = userDao.getUserById(1);

        System.out.println(user);

        sqlSession.close();


    }


    @Test
    public void getUser(){

        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.getUser("%狗%");

        System.out.println(user);

        sqlSession.close();

    }


    //增删改需要进行提交事务
    @Test
    public void addUser(){
        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res =mapper.addUser(new User(10,"10蛋","123"));
        if (res>0){
            System.out.println("插入成功!");
        }
        //进行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){


            //第一步获取到sqlSession对象

            SqlSession sqlSession = MyBatisUtils.getSqlSession();


            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Map<String,Object> map=new HashMap<String, Object>();

            map.put("userid", 5);
            map.put("userName", "狗王");
            map.put("passWord", "123");



            mapper.addUser2(map);

            //进行提交事务
            sqlSession.commit();
            //进行关闭事务
            sqlSession.close();


        }



    @Test
    public  void updateUser(){

        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一:getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int nums = mapper.updateUser(new User(4, "狗蛋", "123"));

        if (nums>0){

            System.out.println("修改成功");
        }

        //进行提交事务
        sqlSession.commit();
        sqlSession.close();




    }

    @Test
    public  void deleteUser(){

        //第一步获取到sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();

        sqlSession.close();
    }


}