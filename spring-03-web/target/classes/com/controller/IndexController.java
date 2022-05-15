package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lqw
 * @date 2022/1/2-5:38 下午
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index.html"})
    public String index(){

        return "index";
    }

}