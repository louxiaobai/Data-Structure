package com.demo03;

import com.demo02.Host;
import com.demo02.Rent;

/**
 * @author lqw
 * @date 2021/10/26-7:25 обнГ
 */
public class Client {

    public static void main(String[] args) {

        Host host = new Host();

        ProxyIncocationHandler pih = new ProxyIncocationHandler();

        pih.setRent(host);

        Rent proxy = (Rent) pih.getProxy();

        proxy.rent();


    }
}