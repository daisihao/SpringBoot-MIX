package com.daisihao.controller;

import com.daisihao.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileNotFoundException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/sendSimple")
    public String sendSimpleEmail() {
        emailService.sendSimpleEmail("461644932@qq.com", "测试标题", "测试内容");
        return "success";
    }

    @RequestMapping("/sendAttachment")
    public String sendAttachmentEmail() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:file/attachment.txt");
            emailService.sendAttachmentEmail("461644932@qq.com", "测试标题", "测试内容", file);
        } catch (FileNotFoundException e) {
        }
        return "success";
    }

    @RequestMapping("/sendTemplate")
    public String sendTemplate() {
        emailService.sendTemplateEmail("461644932@qq.com", "测试标题","template.html");
        return "success";
    }

}
