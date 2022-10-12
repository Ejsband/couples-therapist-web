package ru.couplestherapistweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.entity.MailUser;
import ru.couplestherapistweb.service.AppealService;
import ru.couplestherapistweb.service.ClientService;
import ru.couplestherapistweb.service.DeliveryService;
import ru.couplestherapistweb.service.MailUserService;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DataController {

    private final ClientService clientService;
    private final AppealService appealService;
    private final DeliveryService deliveryService;
    private final MailUserService mailUserService;

    @PostMapping("/appeal")
    @ResponseBody
    public void appeal(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String text,
            @RequestParam String value
    ) {
        if(value.equals("correct") && !name.equalsIgnoreCase("henryavevy")) {
            String id = UUID.randomUUID().toString();
            Appeal appeal = new Appeal(id, name, phone, email, text, LocalDateTime.now());
            MailUser mailUser = mailUserService.findByName("info");
            appealService.save(appeal);
            clientService.save(new Client(id, name, phone, email));
            deliveryService.sendEmail(mailUser.getSender(), mailUser.getReceiver(), mailUser.getSubject(), appeal);
        }
    }
}
