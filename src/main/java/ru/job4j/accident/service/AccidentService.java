package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentJdbcTemplate accidentRepository;

    public AccidentService(AccidentJdbcTemplate accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Collection<Accident> getAll() {
        return accidentRepository.getAll();

    }

    public Boolean save(Accident accident) {
        return accidentRepository.save(accident);

    }

    public Accident findById(int id) {
        return accidentRepository.findById(id);
    }

    public Boolean update(Accident accident) {
        return accidentRepository.update(accident);
    }
}
