package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Collection<Accident> findAll() {
        return accidentRepository.findAll();

    }

    public void add(Accident accident) {
        accidentRepository.add(accident);

    }

    public Accident findById(int id) {
        return accidentRepository.findById(id);
    }

    public void update(Accident accident) {
        accidentRepository.update(accident);
    }
}
