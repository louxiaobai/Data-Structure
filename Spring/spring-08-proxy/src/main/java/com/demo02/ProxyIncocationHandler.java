package com.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lqw
 * @date 2021/10/26-7:11 下午
 */
public class ProxyIncocationHandler implements InvocationHandler {

    private Rent rent;

    public void setRent(Rent rent){

        this.rent=rent;

    }
    public Object getProxy(){

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }


    //代理处理实例,并切返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(rent, args);

        return result;
    }
}