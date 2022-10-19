package ru.job4j.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {
    private final AccidentRepository accidentsRepository;

    public void create(Accident accident) {
        accidentsRepository.save(accident);
    }

    public List<Accident> getAll() {
        var result = new ArrayList<Accident>();
        for (var accident : accidentsRepository.findAll()) {
            result.add(accident);
        }
        return result;
    }
}
