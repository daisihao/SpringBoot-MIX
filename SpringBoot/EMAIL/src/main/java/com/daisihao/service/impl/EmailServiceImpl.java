package com.daisihao.service.impl;

import com.daisihao.configuration.EmailConfig;
import com.daisihao.service.EmailService;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

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
    public void sendAttachmentEmail(String sendTo, String title, String content, File file) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(title);
            helper.setText(content);

            FileSystemResource rs = new FileSystemResource(file);
            helper.addAttachment("附件",file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }

    @Override
    public void sendTemplateEmail(String sendTo, String title, String content,String info) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo(sendTo);
            helper.setSubject(title);
            helper.setText(content);

            //封装模板需要使用的数据
            Map<String,Object> model = new HashMap<>();
            model.put("username","代思豪哈哈哈");

            //根据templates下的html得到相应的Freemarker模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(info);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }
}
