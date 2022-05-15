package com.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lqw
 * @date 2021/11/14-3:45 下午
 */
public class LoginInterceptor  implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        System.out.println("uri: " + request.getRequestURI());
        //放行判断:判断什么情况下登陆
        //登陆页面放行和 有人登陆也进行放行

        if (request.getRequestURI().contains("Login")){
            return true;
        }
        if (request.getRequestURI().contains("goLogin")){
            return true;
        }
        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }

        //进行判断什么情况下没有登陆
       request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return true;
    }
}