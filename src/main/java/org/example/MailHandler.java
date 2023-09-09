package org.example;

import com.sun.jdi.connect.Transport;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
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
          mailmessage.setRecipient(Message.RecepientType.To, new InternetAddress("raivandana9999@gmail.com"));
          mailmessage.setText("Pagal Insan haii tu....");
          Transport.send(mailmessage);
      }
      catch(Exception e){
          System.out.println("some error");
      }

    }
}
