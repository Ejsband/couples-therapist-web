package ru.couplestherapistweb.service;

import ru.couplestherapistweb.entity.Agreement;

public interface AgreementService {
    Agreement findByName(String name);
}
