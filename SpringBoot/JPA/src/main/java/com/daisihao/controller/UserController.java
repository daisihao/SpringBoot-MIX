package com.daisihao.controller;


import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/save")
    public String saveUser(){
        User user = new User();
        user.setName("daisihao");
        user.setPassword("password");
        user.setEmail("email");
        user.setDate(new Date());
        userService.addUser(user);
        return "ok";
    }

    @RequestMapping("/del/{id}")
    public String delUser(@PathVariable int id){
        userService.delUser(id);
        return "success";
    }
}
