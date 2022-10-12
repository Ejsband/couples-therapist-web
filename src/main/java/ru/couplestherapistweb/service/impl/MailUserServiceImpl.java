package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.MailUser;
import ru.couplestherapistweb.repository.MailUserRepository;
import ru.couplestherapistweb.service.MailUserService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MailUserServiceImpl implements MailUserService {

    private final MailUserRepository mailUserRepository;

    @Override
    public MailUser findByName(String name) {
        return mailUserRepository.findByName(name);
    }
}
