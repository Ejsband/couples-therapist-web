package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Appeal;

import java.util.List;

public interface AppealRepository {
    Appeal findById(String id);
    List<Appeal> findAll();
    void save(Appeal appeal);
}
