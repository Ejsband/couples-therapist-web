package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.MailUser;

public interface MailUserService {
    MailUser findByName(String name);
}
