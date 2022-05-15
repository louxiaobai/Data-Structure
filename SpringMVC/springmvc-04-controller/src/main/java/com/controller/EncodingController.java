package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lqw
 * @date 2021/11/8-8:17 下午
 */
@Controller
public class EncodingController {

    @PostMapping("e1/t1")
     public String test1(String name, Model model){

        model.addAttribute("msg", name);
        System.out.println(name);
         return "hello";
     }
}