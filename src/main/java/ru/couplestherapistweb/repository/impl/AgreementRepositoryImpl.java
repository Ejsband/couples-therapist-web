package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Agreement;
import ru.couplestherapistweb.repository.AgreementRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AgreementRepositoryImpl implements AgreementRepository {

    private final EntityManager entityManager;

    @Override
    public Agreement findByName(String name) {
        return entityManager.createQuery("SELECT a FROM Agreement a WHERE a.name = :name", Agreement.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
