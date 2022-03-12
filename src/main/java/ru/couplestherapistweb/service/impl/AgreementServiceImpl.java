package ru.couplestherapistweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Agreement;
import ru.couplestherapistweb.repository.AgreementRepository;
import ru.couplestherapistweb.service.AgreementService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Autowired
    public AgreementServiceImpl(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public Agreement findByName(String name) {
        return agreementRepository.findByName(name);
    }
}
