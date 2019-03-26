package com.daisihao.controller;

import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public User findUserByid(@PathVariable int id){
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping("/save")
    public String saveUser(){
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setEmail("test");
        userService.saveUser(user);
        return "success";
    }
}
