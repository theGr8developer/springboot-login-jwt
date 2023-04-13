package com.emailsend.emailsend.service;

import com.emailsend.emailsend.emailmodel.EmailDetail;



public interface EmailService {
    public String SendSimpleEmail(EmailDetail emailDetail);

    public String SendMailWithAttachement(EmailDetail emailDetail);
}
