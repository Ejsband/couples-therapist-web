package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.repository.ClientRepository;

import javax.persistence.EntityManager;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    private final EntityManager entityManager;

    @Autowired
    public ClientRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Client client) {
        entityManager.persist(client);
    }
}
