package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

@Component
@EnableAsync
public class EmailUtil {

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private I18nUtil i18nUtil;

    public void sendEmail(String toEmail,int code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(toEmail);
        if(toEmail.equals("1259699442@qq.com")){
            System.out.println("=======");
        }
        //message.setTo("1259699442@qq.com");
        //message.setSubject(i18nUtil.getMsg(ConstantUtil.SUBJECT));
        //message.setText(i18nUtil.getMsg(ConstantUtil.CODE).concat(String.valueOf(code)));
        message.setSubject("验证码");
        String me = "welcome to milk system，code：";
        message.setText(me.concat(String.valueOf(code)));
        mailSender.send(message);
    }
}
