package com.demo01;

import com.demo02.Host;

/**
 * @author lqw
 * @date 2021/10/25-9:08 ����
 */
public class Client {

    public static void main(String[] args) {

        Host host=new Host();
        //��̬����ģʽ
        Proxy proxy = new Proxy(host);
        proxy.deal();

    }
}