package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Data;

public interface DataRepository {
    Data findByName(String name);
}
