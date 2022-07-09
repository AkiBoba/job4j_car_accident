package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

@Controller
public class AccidentControl {
    private final AccidentRepository accidents;

    public AccidentControl(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.add(accident);
        return "redirect:/";
    }

    @GetMapping ("/edit")
    public String edit(@ModelAttribute Accident accident, Model model) {
        model.addAttribute("accident", accident);
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/";
    }
}
