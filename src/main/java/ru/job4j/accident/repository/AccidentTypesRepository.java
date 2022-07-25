package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccidentTypesRepository {

    private final List<AccidentType> types = new ArrayList<>();

    private AccidentTypesRepository() {
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
    }

    public List<AccidentType> findAll() {
        return types;
    }

    public AccidentType findById(int id) {
        return types
                .stream()
                .filter(type -> type.getId() == id)
                .findFirst()
                .get();
    }
}
