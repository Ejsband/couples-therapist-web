package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.MailServer;
import ru.couplestherapistweb.repository.MailServerRepository;

import javax.persistence.EntityManager;

@Repository
public class MailServerRepositoryImpl implements MailServerRepository {

    private final EntityManager entityManager;

    @Autowired
    public MailServerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public MailServer findByName(String name) {
        return entityManager.createQuery("SELECT m FROM MailServer m WHERE m.name = :name", MailServer.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
