package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Agreement;
import ru.couplestherapistweb.repository.AgreementRepository;
import ru.couplestherapistweb.service.AgreementService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public Agreement findByName(String name) {
        return agreementRepository.findByName(name);
    }


}
