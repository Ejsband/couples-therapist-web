package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Appeal;

import java.util.List;

public interface AppealService {
    Appeal findById(String id);
    List<Appeal> findAll();
    void save(Appeal appeal);
}
