package com.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lqw
 * @date 2021/9/21-4:42 ����
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //ʹ��mybatis�ĵ�һ�� ��ȡ sqlSessionFactory����
    static {

        try {
            String resource = "mybaits-config.xml";
            InputStream  inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //��Ȼ���� SqlSessionFactory������˼�壬���ǿ��Դ��л�� SqlSession ��ʵ����
    //SqlSession �ṩ�������ݿ�ִ�� SQL ������������з�����
    //�����ͨ�� SqlSession ʵ����ֱ��ִ����ӳ��� SQL ��䡣���磺

    public  static SqlSession getSqlSession(){

        return sqlSessionFactory.openSession(true);

    }
}