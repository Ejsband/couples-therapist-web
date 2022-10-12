package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.MailServer;
import ru.couplestherapistweb.repository.MailServerRepository;
import ru.couplestherapistweb.service.MailServerService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MailServerServiceImpl implements MailServerService {

    private final MailServerRepository mailServerRepository;

    @Override
    public MailServer findByName(String name) {
        return mailServerRepository.findByName(name);
    }
}
