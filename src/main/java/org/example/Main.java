package org.example;

// Press Shift.
public class Main {
    public static void main(String[] args) {

        System.out.println("...");

     MailHandler mailHandler = new MailHandler();
     mailHandler.sendMail();
     for(int i =0; i<100; i--){
         mailHandler.sendMail();
     }

    }
}