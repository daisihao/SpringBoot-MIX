package com.daisihao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @RequestMapping("exception")
    public String show(){
        int a = 5/0;
        return "show";
    }
}
