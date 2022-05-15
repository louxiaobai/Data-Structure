package com.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lqw
 * @date 2021/11/8-10:29 上午
 */
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();

        //业务代码
        String  result="HelloSpringMVC";
        mv.addObject("msg", result);
        //视图跳转
        mv.setViewName("test");

        return mv;
    }
}