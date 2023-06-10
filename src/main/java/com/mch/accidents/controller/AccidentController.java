package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.entity.AccidentType;
import com.mch.accidents.entity.Rule;
import com.mch.accidents.service.AccidentService;
import com.mch.accidents.service.AccidentTypeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("accidents")
public class AccidentController {

    private final AccidentService accidents;
    private final AccidentTypeService accidentsType;

    @GetMapping("/add")
    public String viewCreateAccident(Model model) {
        List<AccidentType> types = accidentsType.findAll();
        model.addAttribute("types", types);
        List<Rule> rules = List.of(
                new Rule(1, "Статья. 1"),
                new Rule(2, "Статья. 2"),
                new Rule(3, "Статья. 3")
        );
        model.addAttribute("rules", rules);
        return "addAccident";
    }

    @PostMapping("/add")
    public String saveAccident(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident);
        return "redirect:/index";
    }

    @GetMapping("/{id}")
    public String viewOneAccident(Model model, @PathVariable int id) {
        Optional<Accident> accident = accidents.findById(id);
        if (accident.isEmpty()) {
            model.addAttribute("message", "Инцидент с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("accident", accident.get());
        return "one";
    }

    @PostMapping("/update")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }

}