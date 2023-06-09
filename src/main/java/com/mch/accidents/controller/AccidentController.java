package com.mch.accidents.controller;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.entity.AccidentType;
import com.mch.accidents.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("accidents")
public class AccidentController {

    private final AccidentService accidents;

    @GetMapping("/add")
    public String viewCreateAccident(Model model) {
        List<AccidentType> types = new ArrayList<>();
        types.add(new AccidentType(1, "Две машины"));
        types.add(new AccidentType(2, "Машина и человек"));
        types.add(new AccidentType(3, "Машина и велосипед"));
        model.addAttribute("types", types);
        return "addAccident";
    }

    @PostMapping("/add")
    public String saveAccident(@ModelAttribute Accident accident) {
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
        model.addAttribute("accident", accident);
        return "one";
    }

    @PostMapping("/update")
    public String updateAccident(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }

}