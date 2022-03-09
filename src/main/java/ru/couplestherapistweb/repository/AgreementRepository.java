package ru.couplestherapistweb.repository;

import ru.couplestherapistweb.entity.Agreement;

public interface AgreementRepository {
    Agreement findByName(String name);
}
