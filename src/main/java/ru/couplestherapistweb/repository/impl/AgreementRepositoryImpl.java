package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Agreement;
import ru.couplestherapistweb.repository.AgreementRepository;

import javax.persistence.EntityManager;

@Service
public class AgreementRepositoryImpl implements AgreementRepository {

    private final EntityManager entityManager;

    @Autowired
    public AgreementRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Agreement findByName(String name) {
        return entityManager.createQuery("SELECT a FROM Agreement a WHERE a.name = :name", Agreement.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
