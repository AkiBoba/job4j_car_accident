package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccidentRuleRepository {

    private final List<Rule> rules = new ArrayList<>();

    private AccidentRuleRepository() {
        rules.add(Rule.of(1, "Статья 1"));
        rules.add(Rule.of(2, "Статья 2"));
        rules.add(Rule.of(3, "Статья 3"));
    }

    public List<Rule> findAll() {
        return rules;
    }

    public Rule findById(int id) {
        return rules
                .stream()
                .filter(rule -> rule.getId() == id)
                .findFirst()
                .get();
    }

}
