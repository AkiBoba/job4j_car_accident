package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentRuleRepository;
import ru.job4j.accident.repository.AccidentTypesRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AccidentControl {
    private final AccidentRepository accidents;
    private final AccidentTypesRepository types;
    private final AccidentRuleRepository rules;

    public AccidentControl(AccidentRepository accidents, AccidentTypesRepository types, AccidentRuleRepository rules) {
        this.accidents = accidents;
        this.types = types;
        this.rules = rules;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("rules", rules.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        accident.setRule(this.getRules(req));
        accident.setType(types.findById(accident.getType().getId()));
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping ("/formEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("accident", accidents.findById(id));
        model.addAttribute("rules", rules.findAll());
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident, HttpServletRequest req) {
        accident.setRule(this.getRules(req));
        accident.setType(types.findById(accident.getType().getId()));
        accidents.update(accident);
        return "redirect:/";
    }

    Set<Rule> getRules(HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Set<Rule> list = new HashSet<>();
        for (String id : ids) {
            int idr = Integer.parseInt(id);
            list.add(rules.findById(idr));
        }
        return list;
    }
}
