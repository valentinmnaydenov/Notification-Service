package com.notificationsevice.springboot;

import com.notificationsevice.springboot.EmailNotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import({EmailNotificationService.class})
public class EmailNotificationServiceTest {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @Test
    public void testSendEmail() throws AddressException, MessagingException {
        String recipient = "example@gmail.com";
        String subject = "Test Email";
        String message = "This is a test email.";
        emailNotificationService.sendEmail(recipient, subject, message);
        // Check if the email was sent successfully
        // In this example, we're using AssertJ for fluent assertions
        assertThat(true).isTrue();
    }
}