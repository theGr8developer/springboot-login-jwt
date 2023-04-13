package com.emailsend.emailsend.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.emailsend.emailsend.emailmodel.EmailDetail;

import jakarta.mail.internet.MimeMessage;


@Component

public class EmailServiceImp {


        
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String sender;
   
    
    public String SendSimpleEmail(EmailDetail emailDetail){

        //Creating simple mail message
        try{
            System.out.println("============"+sender);
    
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        //Setting up necessary details
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(emailDetail.getRecipient());
        simpleMailMessage.setText(emailDetail.getMsgBody());
        simpleMailMessage.setSubject(emailDetail.getSubject());

        javaMailSender.send(simpleMailMessage);

        System.out.println("mail sent succesfully");

   
}catch(Exception e){
    System.out.println("================"+e.getMessage());
    e.printStackTrace();
}
return "sentmail successfully";
}



//Send Email with attachment

public String SendMailWithAttachment(EmailDetail emailDetail){
    //creating a mime message

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;
    try{

        //setting Multipart true to be send mail with attachment;

        mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(sender);
        mimeMessageHelper.setTo(emailDetail.getRecipient());
        mimeMessageHelper.setText(emailDetail.getMsgBody());
        mimeMessageHelper.setSubject(emailDetail.getSubject());

        //Adding the Attachement

        FileSystemResource file = new FileSystemResource(new File(emailDetail.getAttachment()));

        mimeMessageHelper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);

        System.out.println("send mail successfully");


        return "successfull";
    }
    catch(Exception e){
        e.printStackTrace();
    }

    return "successful;";


}


    
}
