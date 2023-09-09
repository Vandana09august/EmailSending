package org.example;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
    public void sendMail(){
        ///property
        //something like a map

        Properties sysPropMap  = System.getProperties();
        System.out.println(sysPropMap);

        //in this map I want 4 keys and 4 values;
        sysPropMap.put("mail.smtp.host" ,"smtp.gmail.com"); //smtp server
        sysPropMap.put("mail.smtp.port" ,"465"); // smtp port
        sysPropMap.put("mail.smtp.ssl.enable" ,"true"); // ssl secure layer
        sysPropMap.put("mail.smtp.auth" ,""); // authentication

        //authentication

        Authenticator authenticator = new CustomizedMailAuthentication();
        Session mailsession =  Session.getInstance(sysPropMap, authenticator);
        // Authenticator mailAuthenticator = new CustomizedMailAuthenticator();


        //session
        // Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);


        //build the mail
        // my message
        MimeMessage mailmessage = new MimeMessage(mailsession);
        try {
            mailmessage.setFrom(MailConstants.SENDER);
            mailmessage.setSubject("mailing pgl person");
            mailmessage.setRecipient(Message.RecipientType.TO, new InternetAddress("raivandana9999@gmail.com"));
            mailmessage.setText("Ritika kya hai??");
            Transport.send(mailmessage);
        }
        catch(Exception e){
            System.out.println("some error");
        }

    }
}
