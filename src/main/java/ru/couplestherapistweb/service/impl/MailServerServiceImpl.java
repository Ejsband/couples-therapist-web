package ru.couplestherapistweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.MailServer;
import ru.couplestherapistweb.repository.MailServerRepository;
import ru.couplestherapistweb.service.MailServerService;

import javax.transaction.Transactional;

@Service
@Transactional
public class MailServerServiceImpl implements MailServerService {

    private final MailServerRepository mailServerRepository;

    @Autowired
    public MailServerServiceImpl(MailServerRepository mailServerRepository) {
        this.mailServerRepository = mailServerRepository;
    }

    @Override
    public MailServer findByName(String name) {
        return mailServerRepository.findByName(name);
    }
}
