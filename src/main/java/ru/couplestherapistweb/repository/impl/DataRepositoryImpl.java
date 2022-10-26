package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Data;
import ru.couplestherapistweb.repository.DataRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DataRepositoryImpl implements DataRepository {

    private final EntityManager entityManager;

    @Override
    public Data findByName(String name) {
        return entityManager.createQuery("SELECT d FROM Data d WHERE d.name = :name", Data.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
