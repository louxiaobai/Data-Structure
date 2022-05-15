package com;

import com.dao.ProviderMapper;
import com.pojo.Provider;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sun.util.resources.sl.CalendarData_sl;

import java.util.List;
import java.util.Map;

/**
 * @author lqw
 * @date 2021/10/11-8:22 ÏÂÎç
 */
public class ProviderTest {
    @Test
    public void add() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);

        Provider provider=new Provider();

        provider.setId(1);
        provider.setProCode("123");
        provider.setProName("¶þµ°");
        int add = mapper.add(provider);

        sqlSession.close();


    }
    @Test
    public void getProviderList() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);

        List<Provider> providerList = mapper.getProviderList("¶þµ°", "123");

        for (Provider provider : providerList) {

            System.out.println(provider);

        }

        sqlSession.close();


    }
    @Test
    public void deleteProviderById() throws Exception {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);

        int i = mapper.deleteProviderById(1);

        System.out.println(i);

        sqlSession.close();


    }
    @Test
    public void getProviderById() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider providerById = mapper.getProviderById("1");
        System.out.println(providerById);
        sqlSession.close();
    }
    @Test
    public void modify() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider=new Provider();
        provider.setProCode("3534");
        provider.setId(1);
        int modify = mapper.modify(provider);
        System.out.println(modify);
        sqlSession.close();
    }

}