package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Contact;
import ru.couplestherapistweb.repository.ContactRepository;

import javax.persistence.EntityManager;

@Service
public class ContactRepositoryImpl implements ContactRepository {

    private final EntityManager entityManager;

    @Autowired
    public ContactRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Contact findByName(String name) {
        return entityManager.createQuery("SELECT c FROM Contact c WHERE c.name = :name", Contact.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
