package ru.couplestherapistweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.repository.ClientRepository;
import ru.couplestherapistweb.service.ClientService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
}
