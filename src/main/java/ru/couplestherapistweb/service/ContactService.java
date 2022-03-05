package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Contact;

public interface ContactService {
    Contact findByName(String name);
}
