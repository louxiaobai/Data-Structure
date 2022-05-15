package com.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lqw
 * @date 2021/10/25-8:09 下午
 */

//等价与<bean id="user" class="com.pojo.User"/>
@Component
@Scope("prototype")
public class User {


    //相当于<property name="name" value="二狗子"/>
    @Value("二狗子")
    public String name;

}