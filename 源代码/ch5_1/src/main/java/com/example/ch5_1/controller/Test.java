package com.example.ch5_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/test")
    public String test(){
        //根据Tymeleaf模板，默认将返回src/main/resources/templates/index.html
        return "test";
    }
}
