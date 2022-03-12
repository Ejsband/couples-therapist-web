package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.MailUser;
import ru.couplestherapistweb.repository.MailUserRepository;

import javax.persistence.EntityManager;

@Repository
public class MailUserRepositoryImpl implements MailUserRepository {

    private final EntityManager entityManager;

    @Autowired
    public MailUserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public MailUser findByName(String name) {
        return entityManager.createQuery("SELECT m FROM MailUser m WHERE m.name = :name", MailUser.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
