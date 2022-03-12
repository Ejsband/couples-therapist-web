package ru.couplestherapistweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Appeal;
import ru.couplestherapistweb.repository.AppealRepository;
import ru.couplestherapistweb.service.AppealService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Autowired
    public AppealServiceImpl(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

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
