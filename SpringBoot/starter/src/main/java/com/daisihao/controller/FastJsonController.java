package com.daisihao.controller;


import com.daisihao.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FastJsonController {
    @RequestMapping("/fastjson")
    @ResponseBody
    public Object show(){
        Person person = new Person();
        person.setId(11);
        person.setName("代思豪");
        person.setSex("男");
        return person;
    }
}
