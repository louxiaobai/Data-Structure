package com.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author lqw
 * @date 2021/10/26-8:18 下午
 */
public class AfterLog implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {


        System.out.println("执行了"+method.getName()+"方法,返回结果为:"+returnValue);



    }
}