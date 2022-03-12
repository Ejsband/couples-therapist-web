package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.MailUser;

public interface MailUserRepository {
    MailUser findByName(String name);
}
