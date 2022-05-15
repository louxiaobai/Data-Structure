package com.demo01;

import com.demo02.Host;

/**
 * @author lqw
 * @date 2021/10/25-9:08 下午
 */
public class Client {

    public static void main(String[] args) {

        Host host=new Host();
        //静态代理模式
        Proxy proxy = new Proxy(host);
        proxy.deal();

    }
}