package com.demo03;

import com.demo02.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lqw
 * @date 2021/10/26-7:11 下午
 */
public class ProxyIncocationHandler implements InvocationHandler {

    private Object target;

    public void setRent(Object target){

        this.target=target;

    }
    public Object getProxy(){

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    //代理处理实例,并切返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        Object result = method.invoke(target, args);

        return result;
    }

    //增加一个日志功能

    public void log(String msg){

        System.out.println("执行了"+msg+"方法");
    }
}