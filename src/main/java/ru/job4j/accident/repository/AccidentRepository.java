package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepository {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final AtomicInteger ids = new AtomicInteger();

    private AccidentRepository() {
        accidents.put(ids.incrementAndGet(), new Accident(1, "DTP", "DTP", "1st"));
        accidents.put(ids.incrementAndGet(), new Accident(2, "DTP2", "DTP2", "2st"));
        accidents.put(ids.incrementAndGet(), new Accident(3, "DTP3", "DTP3", "3st"));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void add(Accident accident) {
        accident.setId(ids.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);

    }
}
