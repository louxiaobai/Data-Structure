package com.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author lqw
 * @date 2021/10/26-8:18 ����
 */
public class AfterLog implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {


        System.out.println("ִ����"+method.getName()+"����,���ؽ��Ϊ:"+returnValue);



    }
}