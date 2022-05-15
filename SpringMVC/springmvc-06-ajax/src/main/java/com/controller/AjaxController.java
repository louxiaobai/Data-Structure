package com.controller;

import com.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lqw
 * @date 2021/11/14-9:41 上午
 */
@RestController
public class AjaxController {


    @RequestMapping("/t1")
    public String test(){

        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {

        System.out.println("a1:param=>"+name);

        if ("xiao".equals(name)){
            response.getWriter().println("true");
        }else {

            response.getWriter().println("false");
        }


    }
    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("二蛋",1,"男"));
        users.add(new User("三蛋",2,"女"));
        return users;
    }
    @RequestMapping("/a3")
    public String a3(String name,String password){
        String msg="";

        System.out.println(password);
        if (name!=null){

            if ("admin".equals(name)){

                msg="ok";

            }else{

                msg="账号输入有误";

            }

        }

        if (password!=null){

            if ("admin".equals(password)){

                msg="ok";

            }else{

                msg="密码输入有误";
            }

        }

        return msg;

    }

}