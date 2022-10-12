package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.service.DeliveryService;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final JavaMailSender mailSender;

    public void sendEmail(String sender, String receiver, String subject, Appeal appeal) {

        String template = String.format("""
                                        Заявка на консультацию
                
                Имя: %s
                Телефон: +7 %s
                E-mail: %s
                
                %s


                Сообщение автоматически сгенерировано сайтом www.vladimirmoroz.ru и не требует ответа.
                """, appeal.getName(), appeal.getPhone(), appeal.getEmail(), appeal.getText());

        MimeMessagePreparator mail = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
                mimeMessage.setFrom(new InternetAddress(sender));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(template);
            }
        };
        try {
            this.mailSender.send(mail);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
