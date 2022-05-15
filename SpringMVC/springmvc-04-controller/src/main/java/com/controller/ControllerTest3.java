package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lqw
 * @date 2021/11/8-3:14 下午
 */
@Controller
@RequestMapping("/c1")
public class ControllerTest3 {


    @RequestMapping("/t1")
    public String test1(Model model){

        model.addAttribute("msg", "contrllertest3");

        return "hello";


    }
}