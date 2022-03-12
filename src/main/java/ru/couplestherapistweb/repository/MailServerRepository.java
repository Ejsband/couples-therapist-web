package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.MailServer;

public interface MailServerRepository {
    MailServer findByName(String name);
}
