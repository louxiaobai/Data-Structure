package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lqw
 * @date 2021/11/8-10:52 上午
 */
@Controller//注解实现
public class HelloController {

    @RequestMapping("/hello") //这是 在浏览器上面写访问路径
    public String  hello(Model model){

        //进行数据的封装
        model.addAttribute("msg", "HelloSpringmvc");
        return "hello";//会被视图解析器处理(hello是视图的名字)
        

    }
}