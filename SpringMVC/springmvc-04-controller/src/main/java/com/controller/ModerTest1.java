package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lqw
 * @date 2021/11/8-4:32 下午
 */
@Controller
public class ModerTest1 {

    @GetMapping("/m1/t1")
    public String test(Model model){
        //过滤器解决乱码
//        转发
        model.addAttribute("msg", "是我");

        return "redirect:/index.jsp";
    }

}