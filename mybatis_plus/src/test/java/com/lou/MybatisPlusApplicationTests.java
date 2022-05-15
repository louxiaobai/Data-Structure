package com.lou;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lou.mapper.UserMapper;
import com.lou.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    //继承了BaseMapper,所有的方法都来自父类
    //我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;


    //测试查询操作
    @Test
    void contextLoads() {

        //参数是一个wapper--条件构造器,这里我们先不用(null)
        //查询全部的用户
        List<User> users = userMapper.selectList(null);

        users.forEach(System.out::println);
    }
    //插入测试
    @Test
    void testInsert(){

        User user = new User();
        user.setAge(17);
        user.setName("狗蛋2号");
        user.setEmail("312321321");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);

    }

    //更新测试

    @Test
    void testUpdate(){

        User user = new User();
        user.setId(5L);
        user.setName("狗蛋3号");

        int i = userMapper.updateById(user);

        System.out.println(i);

    }

    //测试乐观锁成功
    @Test
    void testInterceptor(){

        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //修改邮件信息
        user.setName("二狗子");
        user.setEmail("3123213213");

        //3.执行更新操作

        userMapper.updateById(user);



    }

    //测试乐观锁失败
    @Test
    void testInterceptor1(){

        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //修改邮件信息
        user.setName("二狗子");
        user.setEmail("3123213213");

        User user1= userMapper.selectById(1L);
        //修改邮件信息
        user.setName("二狗子1111");
        user.setEmail("3123213213");


        //3.执行更新操作

        userMapper.updateById(user1);

        userMapper.updateById(user);//如果没有乐观锁会覆盖插队线程的值



    }

    //批量查询
    @Test
    void testSelectByBatchId(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));

        users.forEach(System.out::println);


    }
    //条件查询map
    @Test
    void testSelectByBatchaIds(){

        HashMap<String, Object> map = new HashMap<>();
        //自定义查询

        map.put("name", "二狗子");

        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);


    }

    //分页查询
    @Test
    void testPage(){

        Page<User> page = new Page<>(1, 5);

        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
    }

    //测试删除--单个删除
    @Test
    public  void testDeleteById(){

        userMapper.deleteById( 3l);
    }

    //测试删除--多个删除

    @Test
    public void testDeleteBatchId(){

        userMapper.deleteBatchIds(Arrays.asList(1502562522243866626l,5l));
    }

    //测试删除-按照条件删除

    @Test
    public void testDeleteMap(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("name", "Sandy");

        userMapper.deleteByMap(map);


    }









}
