package com.daisihao.service;

public interface EmailService {

    void sendSimpleEmail(String sendTo,String title,String content);
    void sendAttachmentEmail(String sendTo,String title,String content);
    void sendTemplateEmail(String sendTo,String title,String content);

}
