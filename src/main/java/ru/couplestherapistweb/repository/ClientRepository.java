package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Client;

public interface ClientRepository {
    void save(Client client);
    Client findByPhoneAndEmail(String phone, String email);
}
