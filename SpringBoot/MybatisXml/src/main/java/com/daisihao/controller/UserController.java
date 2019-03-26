package com.daisihao.controller;

import com.daisihao.pojo.User;
import com.daisihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(){
        User user = new User();
        user.setName("name");
        user.setPassword("1111");
        user.setEmail("email");
        user.setBirthday(new Date());
        userService.addUser(user);
        return "success";
    }

    @RequestMapping("/findUser/{page}/{rows}")
    @ResponseBody
    public List<User> findUsers(@PathVariable int page,@PathVariable int rows){
        List<User> users = userService.findUsers(page, rows);
        return users;
    }
}
