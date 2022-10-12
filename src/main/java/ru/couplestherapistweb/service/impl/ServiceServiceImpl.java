package ru.couplestherapistweb.service.impl;


import lombok.RequiredArgsConstructor;
import ru.couplestherapistweb.entity.Service;
import ru.couplestherapistweb.repository.ServiceRepository;
import ru.couplestherapistweb.service.ServiceService;

import javax.transaction.Transactional;


@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public Service findByName(String name) {
        return serviceRepository.findByName(name);
    }
}
