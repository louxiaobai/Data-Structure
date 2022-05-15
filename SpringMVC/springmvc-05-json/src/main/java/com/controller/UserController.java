package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lqw
 * @date 2021/11/9-11:19 上午
 */
//@Controller
@RestController//加上这个注解 所有的方法都不走视图解析器了,直接返回一个方法
public class UserController {
    @RequestMapping(value = "/j1")
    @ResponseBody //使用这个他就不会走视图解析器,会直接返回一个字符串--配合@Controller来进行使用的
    public  String json1() throws JsonProcessingException {

        //创建一个jackJson对象
       ObjectMapper mapper=new ObjectMapper();
       User user = new User("二蛋", 12, "男");
       String s = mapper.writeValueAsString(user);
       return s;


    }


}