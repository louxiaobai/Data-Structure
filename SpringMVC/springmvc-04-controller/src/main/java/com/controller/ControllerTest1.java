package com.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lqw
 * @date 2021/11/8-2:38 下午
 */

//只要实现了Contorller接口的类 说明就是一个控制器了
public class ControllerTest1  implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "controllerTest1");
        mv.setViewName("hello");
        return mv;
    }
}