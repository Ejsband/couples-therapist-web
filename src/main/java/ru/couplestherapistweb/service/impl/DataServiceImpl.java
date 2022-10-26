package ru.couplestherapistweb.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.couplestherapistweb.entity.Data;
import ru.couplestherapistweb.repository.DataRepository;
import ru.couplestherapistweb.service.DataService;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public Data findByName(String name) {
        return dataRepository.findByName(name);
    }
}
