package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.repository.ClientRepository;

import javax.persistence.EntityManager;

@Repository
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

    @Override
    public Client findByPhoneAndEmail(String phone, String email) {
        return entityManager.createQuery("SELECT c FROM Client c WHERE c.phone = :phone AND c.email = :email", Client.class)
                .setParameter("phone", phone)
                .setParameter("email", email)
                .getSingleResult();
    }
}
