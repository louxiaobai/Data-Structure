package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lqw
 * @date 2021/11/8-7:56 下午
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.接受前端的数据
        System.out.println("接收前端的参数为+"+name);
        //2.讲返回的结果传递给前端
        model.addAttribute("msg", name);
        return "hello";
    }
    @GetMapping("/t2")
    public String test2(User user){

        System.out.println(user);
        return "hello";
    }
    @GetMapping("/t3")
    public  String test3(ModelMap map){

        return "hello";
    }


}