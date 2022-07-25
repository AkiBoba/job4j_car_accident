package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypesRepository;

@Controller
public class AccidentControl {
    private final AccidentRepository accidents;
    private final AccidentTypesRepository types;

    public AccidentControl(AccidentRepository accidents, AccidentTypesRepository types) {
        this.accidents = accidents;
        this.types = types;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping ("/formEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("accident", accidents.findById(id));
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/";
    }
}
