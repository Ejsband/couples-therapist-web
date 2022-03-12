package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Appeal;

public interface DeliveryService {
    void sendEmail(String sender, String receiver, String subject, Appeal appeal);
}
