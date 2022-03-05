package ru.couplestherapistweb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import ru.couplestherapistweb.entity.Service;
import ru.couplestherapistweb.repository.ServiceRepository;
import ru.couplestherapistweb.service.ServiceService;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service findByName(String name) {
        return serviceRepository.findByName(name);
    }
}
