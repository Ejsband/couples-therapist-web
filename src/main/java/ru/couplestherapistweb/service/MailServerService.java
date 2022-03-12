package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.MailServer;

public interface MailServerService {
    MailServer findByName(String name);
}
