package com.emailsend.emailsend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emailsend.emailsend.emailmodel.EmailDetail;
// import com.emailsend.emailsend.service.EmailService;
import com.emailsend.emailsend.service.EmailServiceImp;

import jakarta.mail.Multipart;

@RestController
public class EmailController {
    

    @Autowired
    private EmailServiceImp emailServiceImp;

   @PostMapping("/send-mail")
    public EmailDetail getEmail(@RequestBody EmailDetail emailDetail){

        System.out.println("====="+ emailDetail.getMsgBody() + " "+emailDetail.getRecipient()+"=======  ");

        System.out.println("controller is calling");

            emailServiceImp.SendSimpleEmail(emailDetail);
            return emailDetail;

    }

    @GetMapping("/home")
    @ResponseBody
    public String home(){

        return "hi please confirm your mail";
    }


    @RequestMapping(value="/mail-attachment",method=RequestMethod.POST)
    public EmailDetail sendMAilWithAttachementA(@RequestBody EmailDetail emailDetail ){

        System.out.println("============= "+ emailDetail.getMsgBody()+"==="+emailDetail.getAttachment());
        emailServiceImp.SendMailWithAttachment(emailDetail);

        return emailDetail;

    }
}
