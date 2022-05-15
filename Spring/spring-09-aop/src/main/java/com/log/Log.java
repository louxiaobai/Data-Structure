package com.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lqw
 * @date 2021/10/26-8:15 下午
 */
public class Log implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object target) throws Throwable {

        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");

    }
}