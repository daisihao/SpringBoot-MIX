package com.daisihao.controller;


import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        User user = new User();
        user.setName("daisihao");
        user.setPassword("password");
        user.setEmail("email");
        user.setDate(new Date());
        userService.saveUser(user);
        return "success";
    }

}
