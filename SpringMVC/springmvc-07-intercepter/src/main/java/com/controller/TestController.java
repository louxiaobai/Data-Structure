package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lqw
 * @date 2021/11/14-2:57 下午
 */
@RestController
public class TestController {

    @GetMapping("/a1")
    public String test(){

        System.out.println("TestController执行了===》");

        return "ok";

    }
}