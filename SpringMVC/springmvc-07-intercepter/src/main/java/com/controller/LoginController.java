package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lqw
 * @date 2021/11/14-3:36 下午
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){

        return "main";
    }
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "main";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户的信息存在session中
        System.out.println("我来了！！");
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username", username);
        return "main";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session,String username,String password){

        //进行注销sessio

        session.removeAttribute("username");

        return "login";
    }




}