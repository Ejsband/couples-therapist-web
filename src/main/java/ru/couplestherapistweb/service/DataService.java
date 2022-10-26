package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Data;

public interface DataService {
    Data findByName(String name);
}
