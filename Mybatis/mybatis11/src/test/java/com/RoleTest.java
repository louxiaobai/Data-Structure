package com;

import com.dao.RoleMapper;
import com.pojo.Role;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author lqw
 * @date 2021/10/11-4:22 ÏÂÎç
 */
public class RoleTest {

    @Test
    public void addTest() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        Role role=new Role(1, "1", "¶þ¹·", 1, new Date(), 1, new Date());

        int add = mapper.add(role);

        System.out.println(add);

        sqlSession.close();

    }
    @Test
    public void selectTest() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.getRoleList();

        for (Role role : roleList) {
            System.out.println(role);
        }

        sqlSession.close();
    }
    @Test
    public void deleteTest() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        int i = mapper.deleteRoleById("1");

        System.out.println(i);

        sqlSession.close();


    }
    @Test
    public void updateTest() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        Role role = new Role();
        role.setRoleCode("123");
        role.setRoleName("¶þµ°");
        role.setId(1);
        int modify = mapper.modify(role);
        System.out.println(modify);
        sqlSession.close();

    }
    @Test
    public void selectOneTest() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role roleById = mapper.getRoleById(1);
        System.out.println(roleById);
    }
    @Test
    public void selectRoleCode() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

        int i = mapper.roleCodeIsExist("123");

        System.out.println(i);


    }

}