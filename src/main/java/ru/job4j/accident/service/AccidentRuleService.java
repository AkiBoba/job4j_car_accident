package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRuleRep;

import java.util.Collection;
import java.util.Set;

@Service
public class AccidentRuleService {

    private final AccidentRuleRep accidentRuleRep;

    public AccidentRuleService(AccidentRuleRep accidentRuleRep) {
        this.accidentRuleRep = accidentRuleRep;
    }

    public Collection<Rule> getRules() {
        return accidentRuleRep.getRules();

    }

    public Rule getById(int ruleId) {
        return accidentRuleRep.getById(ruleId);
    }

    public void save(int acc_id, Set<Rule> rules) {
        accidentRuleRep.save(acc_id, rules);
    }

    public void update(int acc_id, Set<Rule> rules) {
        accidentRuleRep.update(acc_id, rules);
    }

    public Set<Rule> getByAccId(int accId) {
        return accidentRuleRep.getByAccId(accId);
    }
}
