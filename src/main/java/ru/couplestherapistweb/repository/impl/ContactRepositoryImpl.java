package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Contact;
import ru.couplestherapistweb.repository.ContactRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final EntityManager entityManager;

    @Override
    public Contact findByName(String name) {
        return entityManager.createQuery("SELECT c FROM Contact c WHERE c.name = :name", Contact.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
