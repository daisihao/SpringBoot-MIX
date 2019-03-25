package com.daisihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String Index(Model model){
        model.addAttribute("name","代思豪");
        model.addAttribute("status","ok");
        return "index";
    }
}
