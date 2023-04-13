package com.emailsend.emailsend.emailmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
public class EmailDetail {

    //class data member
    private String Recipient;
    private String MsgBody;
    private String Subject;
    private String Attachment;
}

