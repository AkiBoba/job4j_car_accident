package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Boolean save(Accident accident) {
        return jdbc.update(
                "insert into accident (name) values (?)",
                accident.getName()
        ) > 0;
    }

    public List<Accident> getAll() {
        return jdbc.query(
                "select * from accident",
                new BeanPropertyRowMapper<>(Accident.class)
        );
    }

    public Accident findById(int id) {
        return jdbc.query(
                "select * from accident where id = ?",
                new Object[] {id},
                new BeanPropertyRowMapper<>(Accident.class)
                )
                .stream()
                .findAny()
                .orElse(null);
    }

    public Boolean update(Accident accident) {
        return jdbc.update(
                "UPDATE accident SET name = ?, text = ?, address = ? WHERE id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getId()
                ) > 0;
    }
}