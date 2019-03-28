package com.daisihao.service;

import java.io.File;

public interface EmailService {

    void sendSimpleEmail(String sendTo,String title,String content);
    void sendAttachmentEmail(String sendTo, String title, String content, File file);
    void sendTemplateEmail(String sendTo,String title,String content,String info);

}
