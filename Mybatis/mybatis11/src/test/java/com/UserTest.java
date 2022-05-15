package com;

import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/10/11-6:52 下午
 */
public class UserTest {

    @Test
    public void addTest() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUserCode("1");
        mapper.add(user);
        sqlSession.close();




    }
    @Test
    public void selectAll() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> user = mapper.getUser(map);
        for (User user1 : user) {

            System.out.println(user1);
        }


    }
    @Test
    public void selectLoginUser() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User loginUser = mapper.getLoginUser("213");
        System.out.println(loginUser);
    }
    @Test
    public void limit() throws Exception {


        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list= mapper.getUserList("小王", 1, 0, 1);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void count() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getUserCount("小王", 1);
        System.out.println(count);
        sqlSession.close();


    }
    @Test
    public void delete(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(2);
        System.out.println(i);

        sqlSession.close();

    }
    @Test
    public void byId(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void modify(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user=new User();

        user.setUserName("狗蛋");
        user.setUserCode("1");
        user.setId(1);
        int modify = mapper.modify(user);

        System.out.println(modify);

        sqlSession.close();


    }
    @Test
    public void updatePwd(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(1, "3432");
        System.out.println(i);
        sqlSession.close();
    }
}

