package com.daisihao.controller;

import com.daisihao.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/sendSimple")
    public String sendSimpleEmail(){
        emailService.sendSimpleEmail("461644932@qq.com","测试标题","测试内容");
        return "success";
    }
    @RequestMapping("/sendAttachment")
    public String sendAttachmentEmail(){
        emailService.sendAttachmentEmail("","","");
        return "success";
    }
    @RequestMapping("/sendTemplate")
    public String sendTemplate(){
        emailService.sendTemplateEmail("","","");
        return "success";
    }

}
