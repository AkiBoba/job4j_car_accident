package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidenTypeService;
import ru.job4j.accident.service.AccidentRuleService;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AccidentControl {
    private final AccidentService accidents;

    public AccidentControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping ("/formEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident, @RequestParam int typeId, HttpServletRequest request) {
        return "redirect:/";
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam("id") int id) {
        return "redirect:/";
    }
}
