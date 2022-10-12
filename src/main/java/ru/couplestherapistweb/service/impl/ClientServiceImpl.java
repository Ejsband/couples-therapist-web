package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Client;
import ru.couplestherapistweb.repository.ClientRepository;
import ru.couplestherapistweb.service.ClientService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        try {
            clientRepository.findByPhoneAndEmail(client.getPhone(), client.getEmail());
        } catch (Exception e) {
            clientRepository.save(client);
        }
    }
}
