package org.example;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class CustomizedMailAuthentication extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {

   return new PasswordAuthentication(MailConstants.SENDER, MailConstants.APP_PASSWORD.toCharArray());
    }
}
