package com.demo01;

import com.demo02.Host;
import com.demo02.Rent;

/**
 * @author lqw
 * @date 2021/10/25-9:09 ����
 */
public class Proxy implements Rent {


    private Host host;


    public Proxy(Host host){

        this.host=host;


    }



    public void rent() {
        host.rent();
    }

    public void seeHouse(){

        System.out.println("�н���㿴����");
    }

    public void deal(){

        System.out.println("��ɽ��ף�");
    }
}