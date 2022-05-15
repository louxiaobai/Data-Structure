package com.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lqw
 * @date 2021/10/25-8:09 ����
 */

//�ȼ���<bean id="user" class="com.pojo.User"/>
@Component
@Scope("prototype")
public class User {


    //�൱��<property name="name" value="������"/>
    @Value("������")
    public String name;

}