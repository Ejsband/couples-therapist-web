package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.repository.AppealRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppealRepositoryImpl implements AppealRepository {

    private final EntityManager entityManager;

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
