package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Contact;

public interface ContactRepository {
    Contact findByName(String name);
}
