package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.MailServer;
import ru.couplestherapistweb.repository.MailServerRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MailServerRepositoryImpl implements MailServerRepository {

    private final EntityManager entityManager;

    @Override
    public MailServer findByName(String name) {
        return entityManager.createQuery("SELECT m FROM MailServer m WHERE m.name = :name", MailServer.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
