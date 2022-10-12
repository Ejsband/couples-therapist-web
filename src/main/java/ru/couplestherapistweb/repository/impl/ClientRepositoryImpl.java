package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.repository.ClientRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final EntityManager entityManager;

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
