package com.scm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;

import com.scm.services.EmailService;


@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmailService service;

    @Test
    void sendEmailTest(){
        try {
            service.sendEmail("vinaydahariya5@gmail.com", "Just testing email service", "This is SCM2.0 project working on email service");
            System.out.println("Email sent successfully");
        } catch (MailException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
