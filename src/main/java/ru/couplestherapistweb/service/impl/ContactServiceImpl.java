package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Contact;
import ru.couplestherapistweb.repository.ContactRepository;
import ru.couplestherapistweb.service.ContactService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact findByName(String name) {
        return contactRepository.findByName(name);
    }
}
