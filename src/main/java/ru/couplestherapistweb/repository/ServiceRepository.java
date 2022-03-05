package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Service;

public interface ServiceRepository {
    Service findByName(String name);
}
