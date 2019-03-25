package com.daisihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/test")
    public String index(Model model){
        //SpringBoot默认扫描的模板引擎路径为resource/templates
        model.addAttribute("name","代思豪");
        return "index";
    }
}
