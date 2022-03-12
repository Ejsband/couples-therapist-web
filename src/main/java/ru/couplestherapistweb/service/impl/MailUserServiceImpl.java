package ru.couplestherapistweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.MailUser;
import ru.couplestherapistweb.repository.MailUserRepository;
import ru.couplestherapistweb.service.MailUserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class MailUserServiceImpl implements MailUserService {

    private final MailUserRepository mailUserRepository;

    @Autowired
    public MailUserServiceImpl(MailUserRepository mailUserRepository) {
        this.mailUserRepository = mailUserRepository;
    }

    @Override
    public MailUser findByName(String name) {
        return mailUserRepository.findByName(name);
    }
}
