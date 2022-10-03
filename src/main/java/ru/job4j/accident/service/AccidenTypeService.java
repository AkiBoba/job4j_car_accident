package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeRep;

import java.util.List;

@Service
public class AccidenTypeService {
    private final AccidentTypeRep accidentTypeRep;

    public AccidenTypeService(AccidentTypeRep accidentTypeRep) {
        this.accidentTypeRep = accidentTypeRep;
    }

    public List<AccidentType> getTypes() {
        return accidentTypeRep.getTypes();
    }

    public AccidentType getById(int typeId) {
        return accidentTypeRep.getById(typeId);
    }
}
        