package ru.couplestherapistweb.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.couplestherapistweb.service.MailServerService;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailConfiguration {

    private final MailServerService mailServerService;

    @Bean
    public JavaMailSender getJavaMailSender()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailServerService.findByName("smtp").getHost());
        mailSender.setPort(mailServerService.findByName("smtp").getPort());
        mailSender.setUsername(mailServerService.findByName("smtp").getUsername());
        mailSender.setPassword(mailServerService.findByName("smtp").getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
