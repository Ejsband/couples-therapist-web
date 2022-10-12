package ru.couplestherapistweb.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.couplestherapistweb.entity.Service;
import ru.couplestherapistweb.repository.ServiceRepository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ServiceRepositoryImpl implements ServiceRepository {

    private final EntityManager entityManager;

    @Override
    public Service findByName(String name) {
        return entityManager.createQuery("SELECT s FROM Service s WHERE s.name = :name", Service.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
