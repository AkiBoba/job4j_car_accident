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
    private final AccidenTypeService accidenTypeService;
    private final AccidentRuleService accidentRuleService;

    public AccidentControl(AccidentService accidents, AccidenTypeService accidenTypeService, AccidentRuleService accidentRuleService) {
        this.accidents = accidents;
        this.accidenTypeService = accidenTypeService;
        this.accidentRuleService = accidentRuleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidenTypeService.getTypes());
        model.addAttribute("rules", accidentRuleService.getRules());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam int typeId, HttpServletRequest request) {
        int newAccid = accidents.save(accident, typeId);
        if (request.getParameterValues("ruleId") != null) {
            accidentRuleService.save(newAccid, getRules(request));
        }
        return "redirect:/";
    }

    @GetMapping ("/formEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.findById(id));
        model.addAttribute("types", accidenTypeService.getTypes());
        model.addAttribute("rules", accidentRuleService.getRules());
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident, @RequestParam int typeId, HttpServletRequest request) {
        accidents.update(accident, typeId);
        if (request.getParameterValues("ruleId") != null) {
            accidentRuleService.update(accident.getId(), getRules(request));
        }
        return "redirect:/";
    }

    Set<Rule> getRules(HttpServletRequest req) {
        String[] ids = req.getParameterValues("ruleId");
        Set<Rule> list = new HashSet<>();
            for (String id : ids) {
                int idr = Integer.parseInt(id);
                list.add(accidentRuleService.getById(idr));
            }
            return list;
    }

    @GetMapping ("/delete")
    public String delete(@RequestParam("id") int id) {
        accidents.delete(id);
        return "redirect:/";
    }
}
