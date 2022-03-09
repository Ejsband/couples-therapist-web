package ru.couplestherapistweb.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.repository.AppealRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AppealRepositoryImpl implements AppealRepository {

    private final EntityManager entityManager;

    @Autowired
    public AppealRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Appeal findById(String id) {
        return entityManager.createQuery("SELECT a FROM Appeal a WHERE a.id = :id", Appeal.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Appeal> findAll() {
        return entityManager.createQuery("SELECT a FROM Appeal a", Appeal.class)
                .getResultList();
    }

    @Override
    public void save(Appeal appeal) {
        entityManager.persist(appeal);
    }
}
