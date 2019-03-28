package com.daisihao.service.impl;

import com.daisihao.configuration.EmailConfig;
import com.daisihao.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleEmail(String sendTo, String title, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件发送者
        simpleMailMessage.setFrom(emailConfig.getEmailFrom());
        //邮件接受者
        simpleMailMessage.setTo(sendTo);
        //邮件标题
        simpleMailMessage.setSubject(title);
        //邮件内容
        simpleMailMessage.setText(content);
        //发送邮件
        mailSender.send(simpleMailMessage);

    }

    @Override
    public void sendAttachmentEmail(String sendTo, String title, String content) {

    }

    @Override
    public void sendTemplateEmail(String sendTo, String title, String content) {

    }
}
