package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Service;
import ru.couplestherapistweb.repository.ServiceRepository;

import javax.persistence.EntityManager;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {

    private final EntityManager entityManager;

    @Autowired
    public ServiceRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Service findByName(String name) {
        return entityManager.createQuery("SELECT s FROM Service s WHERE s.name = :name", Service.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
