package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Service;

public interface ServiceService {
    Service findByName(String name);
}
