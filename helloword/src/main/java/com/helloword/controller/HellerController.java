package com.helloword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lqw
 * @date 2021/11/21-7:33 下午
 */
@RestController
public class HellerController {

    @GetMapping("/hello")
    public String hello(){
        return "helslo";
    }
}