package com.config;

import com.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lqw
 * @date 2021/10/25-8:34 下午
 */

//这个也会Spring容器托管,注册到容器中,因为它本身就是一个@Component
//@Configuration代表这是一个配置类,就和我们之前看的beans.xml一样
@Configuration
@Import(Config2.class)
public class Config {

    //注册一个bean,就相当于我们之前写的一个bean标签
    //这个方法的名字,就相当于bean标签中的id
    //这个方法的返回值,就相当于bean标中中的class属性
    @Bean
    public User myService() {
        return new User();
    }
}