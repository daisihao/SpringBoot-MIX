package com.daisihao.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/hello")
    public String helloword() {
        return "helloword";
    }
    //接收请求中的参数
    @RequestMapping("info/{msg}")
    public String Show(@PathVariable String msg){
        return msg;
    }
}
