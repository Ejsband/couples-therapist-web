package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.repository.AppealRepository;
import ru.couplestherapistweb.service.AppealService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Override
    public Appeal findById(String id) {
        return appealRepository.findById(id);
    }

    @Override
    public List<Appeal> findAll() {
        return appealRepository.findAll();
    }

    @Override
    public void save(Appeal appeal) {
        appealRepository.save(appeal);
    }
}
